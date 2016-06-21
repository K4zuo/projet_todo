package vue;

import application.Models.ChoseAFaire;
import application.Models.Personne;
import controleur.EcouteurTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Kazuo on 07/06/2016.
 */
public class PanelPrincipal extends JPanel {

    private Personne p;
    private Fenetre f;
    private JTree tree;
    private DefaultTreeModel model;
    private DefaultMutableTreeNode top;
    private EcouteurTree et;
    private JPopupMenu menu;

    public PanelPrincipal(Personne p, Fenetre f) {
        this.p = p;
        this.f = f;
        setLayout(new BorderLayout());
        top = new DefaultMutableTreeNode("Liste des tâches");
        model = new DefaultTreeModel(top);
        tree = new JTree(model);
        createNodes(top);
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView, BorderLayout.CENTER);
        menu = new JPopupMenu();
        menu.add(new JMenuItem("Réserver cette tache"));
        tree.addMouseListener(new EcouteurTree(this));
    }

    public JPopupMenu getMenuContextuel(){
        return menu;
    }

    public JTree getTree(){
        return tree;
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
