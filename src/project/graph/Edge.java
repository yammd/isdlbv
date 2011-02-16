/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.graph;

import java.util.ArrayList;

/**
 *
 * @author mad
 */
public class Edge {

    double distance;
    boolean visited;
    ArrayList<Marker> markers;

    public Edge(int id, double distance)
    {
        this.visited=false;
        this.distance = distance;
    }

    public boolean isVisited()
    {
        return this.visited;
    }

    public void addMarker(Marker m)
    {
        this.markers.add(m);
    }

    public void removeMarker(Marker m)
    {
        this.markers.remove(m);
    }

    @Override
    public String toString()
    {
        String ret="";

        ret=""+this.distance;
        return ret;
    }
}
