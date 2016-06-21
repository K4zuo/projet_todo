package application;

import application.Models.ChoseAFaire;
import application.Models.Personne;
import vue.Fenetre;

import java.util.ArrayList;

/**
 * Created by Kalreg on 07/06/2016.
 */
public class Main {

	public static void main(String[] args) {
		Personne p = new Personne("admin","admin", "admin", "password");
		Fenetre f = new Fenetre(p);
		ChoseAFaire autre = new ChoseAFaire("Autres", 5, p);
		ArrayList<ChoseAFaire> sousListe = new ArrayList<ChoseAFaire>();
		sousListe.add(new ChoseAFaire("Aller manger", 5, p));
		sousListe.add(new ChoseAFaire("Passer le Bulats", 5, p));
		autre.setLesSousTachesAFaire(sousListe);
		ArrayList<ChoseAFaire> liste = new ArrayList<ChoseAFaire>();
		liste.add(new ChoseAFaire("Développer la vue", 1, p));
		liste.add(new ChoseAFaire("Développer le modèle", 3, p));
		liste.add(new ChoseAFaire("Développer le contrôleur", 2, p));
		p.setlChoseAFaire(liste);
		p.addChoseAFaire(autre);
	}
}
