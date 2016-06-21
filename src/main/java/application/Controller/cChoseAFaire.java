package application.Controller;

import application.Models.ChoseAFaire;
import application.Models.Personne;
import application.Utils.CommServer;

import java.awt.*;
import java.net.Socket;
import java.util.Iterator;

/**
 * Created by Max on 14/06/2016.
 */
public class cChoseAFaire {
    //... traitement écouteur

    Socket socket;
    Thread t;

    public void nouveauProjet(){

        Personne pers = new Personne("toto", "titi","admin", "mdp", Color.blue);
        ChoseAFaire chose1 = new ChoseAFaire("NFP121", 5,1, pers); //status = 1 --> en cours
        chose1.setDevEnCharge(pers);
        ChoseAFaire sousChose1, sousChose2, sousChose3;
        sousChose1 = new ChoseAFaire("eval1", 2,1);
        sousChose2 = new ChoseAFaire("eval2", 3,0);
        sousChose3 = new ChoseAFaire("evalFinal", 1,0);

        chose1.addSousChoseAFaire(sousChose1);
        chose1.addSousChoseAFaire(sousChose2);
        chose1.addSousChoseAFaire(sousChose3);
        Iterator<ChoseAFaire> it = pers.iterator();

        t = new Thread(new CommServer("nouveau projet", chose1));
        t.start();

    }

    public void  ajoutChoseAFaire(ChoseAFaire projet, ChoseAFaire nouvelleChose){
        projet.addSousChoseAFaire(nouvelleChose);
        t = new Thread(new CommServer("ajout d'une sous chose a faire", projet));
        t.start();
    }

    public void majStatus(ChoseAFaire chose,int status){
        chose.setStatus(status);
        t = new Thread(new CommServer("maj status", chose));
        t.start();
    }


}


