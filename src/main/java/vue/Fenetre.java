package vue;

import application.Models.Personne;

import javax.swing.*;

/**
 * Created by Kazuo on 07/06/2016.
 */
public class Fenetre extends JFrame {

    private BarreDeMenus barreDeMenus;

    public Fenetre(Personne p) {
        setTitle("ToDo");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new PanelConnexion(p, this));
        setJMenuBar(barreDeMenus = new BarreDeMenus(this));
        setVisible(true);
    }

}
