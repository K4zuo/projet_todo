package vue;

import application.Models.ChoseAFaire;
import application.Models.Personne;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Kazuo on 07/06/2016.
 */
public class PanelPrincipal extends JPanel {

    private Personne p;
    private Fenetre f;
    private JTree tree;

    public PanelPrincipal(Personne p, Fenetre f) {
        this.p = p;
        this.f = f;
        setLayout(new BorderLayout());
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Liste des tâches");
        tree = new JTree(top);
        createNodes(top);
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView, BorderLayout.CENTER);
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode tache = null;
        DefaultMutableTreeNode sousTache = null;
        ArrayList<ChoseAFaire> liste = (ArrayList<ChoseAFaire>) p.getlChoseAFaire();
        for(ChoseAFaire c: liste) {
            if(c.getLesSousTachesAFaire().size()==0){
                top.add(new DefaultMutableTreeNode(c));
            } else {
                DefaultMutableTreeNode sousListe = new DefaultMutableTreeNode(c);
                for(ChoseAFaire s: c.getLesSousTachesAFaire()) {
                    sousListe.add(new DefaultMutableTreeNode(s));
                }
                top.add(sousListe);
            }
        }

    }
}
