package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.ResultSet;

class ThreadClient extends Thread {
	protected Socket branchementAvecLeClient;
	protected BufferedReader ecouteurDuCombine;
	protected PrintStream microphoneDuCombine;
	protected SQLiteJDBC accesBDD;

	/**
	 * Constructor of a ThreadClient
	 * @param uneCommunicationAvecUnClient the client's socket
	 */
	public ThreadClient(Socket uneCommunicationAvecUnClient) {
		branchementAvecLeClient = uneCommunicationAvecUnClient;
		accesBDD.getInstance();
		try {
			ecouteurDuCombine = new BufferedReader(new InputStreamReader(branchementAvecLeClient.getInputStream()));
			microphoneDuCombine = new PrintStream(branchementAvecLeClient.getOutputStream());
		} catch (Exception e) {
			ecouteurDuCombine = null;
			microphoneDuCombine = null;
		}
	}

	/**
	 * This method is executed by the <code>start</code> method.
	 * It gets the query from the client and executes it on the BDD.
	 * @see Thread#start()
	 */
	@Override
	public void run() {
		StringBuilder lu;
		try {
			do {
				lu = new StringBuilder("");
				lu.append(ecouteurDuCombine.readLine());
				if (!"".equals(lu.toString())) {
					if (!".".equals(lu.toString())) {
						System.out.println(lu);
						switch (lu.substring(1, 6).toUpperCase()) {
							case "SELECT":
								accesBDD.executeQuery(lu.toString(), this);
								break;
							default:
								accesBDD.executeUpdate(lu.toString(), this);
								break;
						}
					}
				}
			} while(!".".equals(lu.toString()));
			deconnecte();
		} catch (IOException e) {}
	}

	private void deconnecte() {
		try {
			System.out.println("Deconnexion d'un client");
			branchementAvecLeClient.close();
		} catch (IOException e) {}
	}

	/**
	 * This method is called by the SQLiteJDBC executeQuery method
	 * It send a ResultSet to the client
	 * @see SQLiteJDBC#executeQuery(String, ThreadClient)
	 * @param rs the ResultSet send to the client
	 */
	public void sendResult(ResultSet rs) {
		microphoneDuCombine.print(rs);
	}

	/**
	 * This method is called by the SQLiteJDBC executeUpdate method
	 * It send the number of rows affected by the request (or -1 in case of a problem) to the client
	 * @see SQLiteJDBC#executeUpdate(String, ThreadClient)
	 * @param rowsChanged the number of rows affected by the request (or -1)
	 */
	public void sendRowsChanged(int rowsChanged) {
		microphoneDuCombine.print(rowsChanged);
	}
}
