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

    private int id;
    
    ArrayList<Marker> markers;
    //ArrayList<Node> directs_links;
    
    public Node()
    {

    }
    
    public Node(int id)
    {
        this.id=id;
    }

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
}
