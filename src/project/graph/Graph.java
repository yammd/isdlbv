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
    ArrayList2d<Integer> edges;
    
    public Graph()
    {
        this.incrementkey=0;
        edges = new ArrayList2d<Integer>();
        edges.setDefaultValue(-1); // -1 = no link
    }

    int addNode()
    {
        int key=this.incrementkey;
        Node n=new Node();
        n.setId(key);
        this.nodes.add(n);

        return key;
    }
    

    int linkNodes(int id1, int id2,int distance)
    {
        edges.add(distance, id1, id2);
        return 0;
    }
}
