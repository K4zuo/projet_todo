package application.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Max on 07/06/2016.
 */
public class ChoseAFaire implements Serializable{

    int importance; //de 1 à 5
    String designation;
    boolean choseFaite;
    int status; // 1 = non commencé 2 = en cours  3 = terminée
    List<ChoseAFaire> lesSousTachesAFaire;
    Personne devEnCharge;
    public ChoseAFaire() {
        this.importance = 0;
        this.designation = "";
        this.choseFaite = false;
        this.lesSousTachesAFaire = new ArrayList<ChoseAFaire>();
        this.devEnCharge = null;

    }

    public ChoseAFaire(String libelle, int priorite, int status) {
        this.importance = priorite;
        this.status = status;
        this.designation = libelle;
        this.choseFaite = false;
        this.lesSousTachesAFaire = new ArrayList<ChoseAFaire>();
        this.devEnCharge = null;
    }

    public ChoseAFaire(String libelle, int priorite,int status,Personne dev) {
        this.importance = priorite;
        this.status = status;
        this.designation = libelle;
        this.choseFaite = false;
        this.lesSousTachesAFaire = new ArrayList<ChoseAFaire>();
        this.devEnCharge = dev;
        this.devEnCharge.addChoseAFaire(this);
    }

    public ChoseAFaire(String libelle, int priorite, int status,List<ChoseAFaire> lChoseAFaire, Personne dev) {
        this.importance = priorite;
        this.status = status;
        this.designation = libelle;
        this.choseFaite = false;
        this.lesSousTachesAFaire = lChoseAFaire;
        this.devEnCharge = dev;
    }

    public List<ChoseAFaire> getLesSousTachesAFaire() {
        return lesSousTachesAFaire;
    }

    public void setLesSousTachesAFaire(List<ChoseAFaire> lesSousTachesAFaire) {
        this.lesSousTachesAFaire = lesSousTachesAFaire;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setStatus(int newStatus){
        this.status = newStatus;

        if (this.status == 3){
            this.choseFaite = true;
        }

    }

    public int getStatus(){
        return this.status;
    }

    public void addSousChoseAFaire(ChoseAFaire chose){
        this.lesSousTachesAFaire.add(chose);
    }

    public Personne getDevEnCharge() {
        return devEnCharge;
    }

    public void setDevEnCharge(Personne devEnCharge) {
        this.devEnCharge = devEnCharge;
    }

    public Iterator<ChoseAFaire> iterator(){
        return this.lesSousTachesAFaire.iterator();
    }

    public String toString() {
        String texte = "";
        texte += importance;
        texte += ":";
        texte += designation;
        texte += ":";
        if (choseFaite)
            texte += "fait";
        else
            texte += "a faire";
        return texte;
    }
}
