/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import project.graph.*;

/**
 *
 * @author mad
 */
public class JPanelGraph extends JPanel {

    Graph graph;
    public JPanelGraph()
    {
        super();
        this.graph = null;
        this.setBackground(Color.black);
    }

    public void setGraph(Graph g)
    {
        this.graph = g;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(this.graph != null)
        {
            this.graph.paint(g);
        }
    }
}
