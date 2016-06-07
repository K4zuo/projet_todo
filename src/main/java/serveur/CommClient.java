package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

class CommClient extends Thread {
	protected Socket branchementAvecLeClient;
	protected BufferedReader ecouteurDuCombine;
	protected PrintStream microphoneDuCombine;

	public CommClient(Socket uneCommunicationAvecUnClient) {
		branchementAvecLeClient = uneCommunicationAvecUnClient;
		try {
			ecouteurDuCombine = new BufferedReader(new InputStreamReader(branchementAvecLeClient.getInputStream()));
			microphoneDuCombine = new PrintStream(branchementAvecLeClient.getOutputStream());
		} catch (Exception e) {
			ecouteurDuCombine = null;
			microphoneDuCombine = null;
		}
	}

	public void run() {
		String lu = "";
		try {
			do {
				lu = ecouteurDuCombine.readLine();
				if (lu != null) {
					System.out.println(lu);
					if (!lu.equals(".")) {
						microphoneDuCombine.println(lu.toUpperCase());
					}
				} else {
					lu = "";
				}
			} while(!lu.equals("."));
			deconnecte();
		} catch (IOException e) {}
	}

	public void deconnecte() {
		try {
			System.out.println("Deconnexion d'un client");
			branchementAvecLeClient.close();
			ServeurMain.setContinuer(false);
		} catch (IOException e) {}
	}
}
