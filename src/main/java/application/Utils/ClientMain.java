package application.Utils;

import application.Controller.cChoseAFaire;
import application.Models.ChoseAFaire;
import application.Models.Personne;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

/**
 * Created by Kalreg on 07/06/2016.
 */
public class ClientMain {

	public static void main(String[] args) {

        cChoseAFaire choseController = new cChoseAFaire();
        choseController.nouveauProjet();

    }

	}


/*public class test implements Runnable{

    private ServerSocket socketserver;
    private Socket socket;
    private int nbrclient = 1;
    public test(ServerSocket s){

        socketserver = s;

    }

    public void run() {

        try {

            while(true){
                socket = socketserver.accept(); // Un client se connecte on l'accepte
                //System.out.println("Le client numéro "+nbrclient+ " est connecté !");
                nbrclient++;

                socket.close();

            }



        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}*/
