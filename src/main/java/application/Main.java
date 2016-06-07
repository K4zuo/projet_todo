package application;

import application.Models.Personne;
import vue.Fenetre;

/**
 * Created by Kalreg on 07/06/2016.
 */
public class Main {

	public static void main(String[] args) {
		Personne p = new Personne("admin","admin","password");
		Fenetre f = new Fenetre(p);

	}
}
