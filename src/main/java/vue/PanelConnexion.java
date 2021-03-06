package vue;

import application.Models.Personne;
import controleur.EcouteurConnexion;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kazuo on 07/06/2016.
 */
public class PanelConnexion extends JPanel {

    private JTextField jtfLogin;
    private JPasswordField jpfPassword;

    public PanelConnexion(Personne p, Fenetre f) {

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 10, 0);

        jtfLogin = new JTextField();
        jtfLogin.setPreferredSize(new Dimension(200,30));

        jpfPassword = new JPasswordField();
        jpfPassword.setPreferredSize(new Dimension(200,30));

        JLabel jlbLogin = new JLabel("Login : ");
        JLabel jlbPassword = new JLabel("Password : ");

        JButton jbtConnexion = new JButton("Se connecter");
        jbtConnexion.setPreferredSize(new Dimension(265,30));
        jbtConnexion.addActionListener(new EcouteurConnexion(p, f, this));

        c.gridx = 1;
        c.gridy = 1;
        add(jlbLogin, c);

        c.gridx = 3;
        c.gridy = 1;
        add(jtfLogin, c);

        c.gridx = 1;
        c.gridy = 2;
        add(jlbPassword, c);

        c.gridx = 3;
        c.gridy = 2;
        add(jpfPassword, c);

        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 3;
        add(jbtConnexion, c);
    }

    public JTextField getJtfLogin() {
        return jtfLogin;
    }

    public JPasswordField getJpfPassword() {
        return jpfPassword;
    }
}
