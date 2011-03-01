/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author mad
 */
public class Node {

    final static Color color_unvisited = Color.RED;
    final static Color color_visited = Color.GREEN;
    
    private int id;
    
    private ArrayList<Marker> markers;
    //private ArrayList<Node> directs_links;
    private ArrayList<Integer> links;
    private boolean visited;

    // Graphical information
    private int graphX,graphY;
    private Color current_color;

    public Node()
    {
        this.visited = false;
        this.current_color = Node.color_unvisited;
    }
    
    public Node(int id)
    {
        this.id=id;
        this.visited=false;
    }

    /*public Node(int id,ArrayList<Integer> links)
    {
        this.id=id;
        this.links=links;
    }*/

    @Override
    public String toString()
    {
        String ret="";
        ret="Id = "+this.getId()+"\n";

        return ret;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisited()
    {
        return this.visited;
    }

    public void setVisited()
    {
        this.visited = true;
        this.current_color = Node.color_visited;
    }

    public void setGraphic(int x, int y)
    {
        this.graphX=x;
        this.graphY=y;
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(this.current_color);
        g2.drawOval(this.graphX, this.graphY, 5, 5);
    }
}
