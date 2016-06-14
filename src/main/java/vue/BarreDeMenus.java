package vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kazuo on 07/06/2016.
 */
public class BarreDeMenus extends JMenuBar {

    private Fenetre f;

    public BarreDeMenus(Fenetre f) {
        this.f = f;
        JMenu menuFichier = new JMenu("Fichier");

        JMenuItem jmiAjoutTache = new JMenuItem("Ajouter une tâche");
        menuFichier.add(jmiAjoutTache);

        JMenuItem jmiDeconnexion = new JMenuItem("Se déconnecter");
        menuFichier.add(jmiDeconnexion);

        JMenuItem jmiQuitter = new JMenuItem("Quitter");
        menuFichier.add(jmiQuitter);
        jmiQuitter.addActionListener(
                new ActionListener() {
                    public void	actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );

        add(menuFichier);
    }
}
