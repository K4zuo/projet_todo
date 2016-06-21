package controleur;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import vue.PanelPrincipal;

/**
 * Created by Kazuo on 21/06/2016.
 */
public class EcouteurTree extends MouseAdapter {

    private JTree tree;
    private JPopupMenu menu;

    public EcouteurTree(PanelPrincipal panel) {
        tree = panel.getTree();
        menu = panel.getMenuContextuel();
    }

    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            TreePath path = tree.getPathForLocation (e.getX(), e.getY());
            Rectangle pathBounds = tree.getUI().getPathBounds(tree, path);
            if(pathBounds != null && pathBounds.contains(e.getX(), e.getY()) && path.getParentPath()!=null) {
                menu.show(tree, e.getX(), e.getY());

            }
        }
    }

}
