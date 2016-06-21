package application.Utils;

import application.Models.ChoseAFaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Max on 14/06/2016.
 */
public class CommServer implements Runnable {
    Socket socket;
    BufferedReader in;
    PrintStream out;
    ChoseAFaire choseATransmette;
    String operation; // nouveau projet, choisir projet, ajout d'une sous chose a faire, maj status

    public CommServer(String operation, ChoseAFaire chose){
        this.choseATransmette = chose;
        this.operation = operation;
    }


    @Override
    public void run() {
        try {

            socket = new Socket("localhost",3000);
            System.out.println("demande de connexion");
            out = new PrintStream(socket.getOutputStream());
            out.println(this.operation);
            out.println(choseATransmette);
            out.flush();
            socket.close();
            System.out.println("fin connexion");
        } catch(IOException e) {

            e.printStackTrace();

        }
    }
}
