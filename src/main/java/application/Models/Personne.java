package application.Models;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Max on 07/06/2016.
 */
public class Personne implements Serializable{
    String nom;
    String prenom;
    String pseudo;
    String password;
    Color couleur;
    List<ChoseAFaire> lChoseAFaire = new ArrayList<>();

    public Personne() {
    }

    public Personne(String nom, String prenom, String pseudo, String password){
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.password = password;
    }

    public Personne(String nom, String prenom,String pseudo,String password, Color couleur){
        this(nom, prenom, pseudo, password);
        this.couleur = couleur;
    }

    public Personne(String nom, String prenom,String pseudo,String password, Color couleur, List<ChoseAFaire> lChoseAFaire) {
        this(nom, prenom, pseudo, password, couleur);
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

    public String getPseudo() {
        return pseudo;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void addChoseAFaire(ChoseAFaire chose){
        this.lChoseAFaire.add(chose);
    }

    public void delChoseAFaire(ChoseAFaire chose){
        this.lChoseAFaire.remove(chose);
    }

    public Iterator<ChoseAFaire> iterator(){
        return this.lChoseAFaire.iterator();
    }
}
