/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.graph;

import java.util.ArrayList;
import project.misc.ArrayList2d;

/**
 *
 * @author mad
 */
public class Graph {

    int incrementkey;
    ArrayList<Node> nodes;
    ArrayList2d<Edge> edges;
    
    public Graph()
    {
        this.incrementkey=0;
        this.nodes = new ArrayList<Node>();
        edges = new ArrayList2d<Edge>();
        edges.setDefaultValue(null); // -1 = no link
    }

    public int addNode()
    {
        int key=this.incrementkey;
        Node n=new Node();
        n.setId(key);
        this.nodes.add(n);

        return key;
    }

    public int addNode(int gkey)
    {
        Node n=new Node();
        n.setId(gkey);
        this.nodes.add(n);

        return gkey;
    }
    

    public void linkNodes(int edgeId, int id1, int id2,double distance)
    {
        Edge e = new Edge(edgeId,distance);
        edges.add(e, id1, id2);
        edges.add(e, id2, id1);
    }

    @Override
    public String toString()
    {
        String ret="";
        ret = this.edges.toString();
        return ret;
    }
}
