package application.Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Max on 07/06/2016.
 */
public class ChoseAFaire{

    int importance; //de 1 à 5
    String designation;
    boolean choseFaite;
    String status;
    List<ChoseAFaire> lesSousTachesAFaire;
    Personne devEnCharge;
    public ChoseAFaire() {
        this.importance = 0;
        this.designation = "";
        this.choseFaite = false;
        this.lesSousTachesAFaire = new ArrayList<ChoseAFaire>();
        this.devEnCharge = null;

    }

    public ChoseAFaire(String libelle, int priorite) {
        this.importance = priorite;
        this.designation = libelle;
        this.choseFaite = false;
        this.lesSousTachesAFaire = new ArrayList<ChoseAFaire>();
        this.devEnCharge = null;
    }

    public ChoseAFaire(String libelle, int priorite,Personne dev) {
        this.importance = priorite;
        this.designation = libelle;
        this.choseFaite = false;
        this.lesSousTachesAFaire = new ArrayList<ChoseAFaire>();
        this.devEnCharge = dev;
        this.devEnCharge.addChoseAFaire(this);
    }

    public ChoseAFaire(String libelle, int priorite, List<ChoseAFaire> lChoseAFaire, Personne dev) {
        this.importance = priorite;
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

    public void setStatus(String newStatus){
        this.status = newStatus;

        if (this.status.equals("terminé")){
            this.choseFaite = true;
        }

    }

    public String getStatus(){
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
