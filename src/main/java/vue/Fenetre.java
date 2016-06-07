package vue;

import javax.swing.*;

/**
 * Created by Kazuo on 07/06/2016.
 */
public class Fenetre extends JFrame {

    public Fenetre() {
        setTitle("ToDo");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new PanelConnexion());
        setVisible(true);
    }
}
