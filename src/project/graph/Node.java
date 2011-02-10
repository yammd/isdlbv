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
public class Node {

    int id;
    
    ArrayList<Marker> markers;
    //ArrayList<Node> directs_links;
    
    public Node()
    {

    }
    
    public Node(int id)
    {
        this.id=id;
    }
}
