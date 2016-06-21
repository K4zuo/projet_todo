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
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new PanelConnexion(p, this));
        setJMenuBar(barreDeMenus = new BarreDeMenus(this));
        setVisible(true);
    }

    public void redimensionnerFenetre(int x, int y) {
        setSize(x, y);
        setLocationRelativeTo(null);
        this.getContentPane().repaint();
    }

}
