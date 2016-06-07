package controleur;

import application.Models.Personne;
import vue.Fenetre;
import vue.PanelConnexion;
import vue.PanelPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Kazuo on 07/06/2016.
 */
public class EcouteurConnexion implements ActionListener {

    private Personne p;
    private Fenetre f;
    private PanelConnexion pc;

    public EcouteurConnexion(Personne p, Fenetre f, PanelConnexion pc) {
        this.p = p;
        this.f = f;
        this.pc = pc;
    }

    public void actionPerformed(ActionEvent e) {
        if(p.getNom().equals(pc.getJtfLogin().getText()) && p.getPassword().equals(pc.getJtfPassword().getText())) {
            f.setContentPane(new PanelPrincipal(p, f));
            f.paintComponents(f.getContentPane().getGraphics());
        }

    }
}
