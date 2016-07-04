package serveur;

import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMain {
	static org.jdom2.Document serveurPref;
	public final static int PortParDefaut = 3000;
	private static int port;

	public static void main(String[] args) throws Exception {
		serveurPref = new SAXBuilder().build(new File("serveur_preferences.xml"));
		int portPref;
		try {
			portPref = Integer.parseInt(serveurPref.getRootElement().getChild("port").getText());
		} catch (NumberFormatException e) {
			portPref = -1;
		}
		port = (portPref != -1) ? portPref : PortParDefaut;
		ServerSocket leServeur = new ServerSocket(port);
		do {
			Socket branchementClient = leServeur.accept();
			System.out.println("Nouveau client.");
			ThreadClient cc = new ThreadClient(branchementClient);
			cc.start();
		} while(true);
	}
}
