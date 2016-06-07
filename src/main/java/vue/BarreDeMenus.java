package vue;

import javax.swing.*;

/**
 * Created by Kazuo on 07/06/2016.
 */
public class BarreDeMenus extends JMenuBar {

    private Fenetre f;

    public BarreDeMenus(Fenetre f) {
        this.f = f;
        JMenu menu = new JMenu("Fichier");
        JMenuItem it = new JMenuItem("Ajouter une tâche");
        menu.add(it);
        add(menu);
    }
}
