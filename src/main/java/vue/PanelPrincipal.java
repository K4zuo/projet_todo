package vue;

import application.Models.Personne;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kazuo on 07/06/2016.
 */
public class PanelPrincipal extends JPanel {

    private Personne p;
    private Fenetre f;

    public PanelPrincipal(Personne p, Fenetre f) {
        this.p = p;
        this.f = f;
    }
}
