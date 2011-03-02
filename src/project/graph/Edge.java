/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 *
 * @author mad
 */
public class Edge {

    final static Color color_unvisited = Color.WHITE;
    final static Color color_visited = Color.GREEN;

    private double distance;
    private boolean visited;
    private ArrayList<Marker> markers;

    private int graph_x1,graph_x2,graph_y1,graph_y2;
    private Color current_color;
    
    public Edge(int id, double distance)
    {
        this.visited=false;
        this.distance = distance;
        this.current_color = Edge.color_unvisited;
    }

    public boolean isVisited()
    {
        return this.visited;
    }

    public void setVisited()
    {
        this.visited = true;
        this.current_color = Edge.color_visited;
    }
    
    public void addMarker(Marker m)
    {
        this.markers.add(m);
    }

    public void removeMarker(Marker m)
    {
        this.markers.remove(m);
    }

    public void setGraphic(int x1,int x2,int y1, int y2)
    {
        this.graph_x1 = x1;
        this.graph_x2 = x2;
        this.graph_y1 = y1;
        this.graph_y2 = y2;
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(this.current_color);
        //System.out.println("edge "+this.graph_x1+" "+this.graph_x2+" "+this.graph_y1+" "+this.graph_y2);
        Line2D line = new Line2D.Float(this.graph_x1, this.graph_x2, this.graph_y1, this.graph_y2);
        g2.setStroke(new BasicStroke(2));
        g2.draw(line);
    }

    @Override
    public String toString()
    {
        String ret="";

        ret=""+this.distance;
        return ret;
    }
}
