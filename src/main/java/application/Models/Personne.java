package application.Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Max on 07/06/2016.
 */
public class Personne {
    String nom;
    String prenom;
    String password;
    List<ChoseAFaire> lChoseAFaire;

    public Personne() {
    }

    public Personne(String nom, String prenom,String password){
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.lChoseAFaire = new ArrayList<ChoseAFaire>();
    }

    public Personne(String nom, String prenom,String password, List<ChoseAFaire> lChoseAFaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.lChoseAFaire = lChoseAFaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<ChoseAFaire> getlChoseAFaire() {
        return lChoseAFaire;
    }

    public void setlChoseAFaire(List<ChoseAFaire> lChoseAFaire) {
        this.lChoseAFaire = lChoseAFaire;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addChoseAFaire(ChoseAFaire chose){
        this.lChoseAFaire.add(chose);
    }

    public Iterator<ChoseAFaire> iterator(){
        return this.lChoseAFaire.iterator();
    }
}
