/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.graph;

import java.awt.Graphics;
import java.util.*;
import java.util.Map.Entry;
import project.misc.ArrayList2d;

/**
 *
 * @author mad
 */
public class Graph {

    int incrementkey;
    //ArrayList<Node> nodes;
    HashMap< Integer, Node> nodes;
    ArrayList2d<Edge> edges;
    
    public Graph()
    {
        this.incrementkey=0;
        //this.nodes = new ArrayList<Node>();
        this.nodes = new HashMap<Integer,Node>();
        edges = new ArrayList2d<Edge>();
        edges.setDefaultValue(null); // null = no link
    }

    public int addNode()
    {
        int key=this.incrementkey;
        Node n=new Node();
        n.setId(key);
        //this.nodes.add(n);
        this.nodes.put(key, n);

        return key;
    }

    public int addNode(int gkey)
    {
        Node n=new Node();
        n.setId(gkey);
        //this.nodes.add(n);
        this.nodes.put(gkey, n);

        return gkey;
    }
    

    public void linkNodes(int edgeId, int id1, int id2,double distance)
    {
        Edge e = new Edge(edgeId,distance);
        edges.add(e, id1, id2);
        edges.add(e, id2, id1);
    }

    public Node getNode(int key)
    {
        return this.nodes.get(key);
    }

    public Edge getEdge(int id1,int id2)
    {
        return this.edges.get(id1, id2);
    }

    /* Returns the list of node's id reachable in one step
     * from the current_position
     */
    public ArrayList<Integer> getPossiblePathFrom(int current_position)
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        for(int i=0;i<this.edges.getNumCols(current_position);i++)
        {
            if(this.edges.get(current_position, i) != null)
                ret.add(i);
        }
        
        return ret;
    }
    
    /* Move from node id1 to node id2 */
    public void goFromTo(int id1,int id2)
    {
        //System.out.println("Move from "+id1+" to "+id2);
        
        this.nodes.get(id1).setVisited();
        this.nodes.get(id2).setVisited();
        
        this.edges.get(id1, id2).setVisited();
    }

    public boolean isGraphAllVisited()
    {
        boolean ret=true;
        for (int i=0;i<this.edges.getNumRows() && ret == true;i++)
        {
            for(int j=0;j<this.edges.getNumCols(i) && ret == true;j++)
            {
                Edge e = this.getEdge(i, j);
                if( e != null && !e.isVisited())
                {
                    ret = false;
                    //break;
                }
            }
        }
        return ret;
    }

    public int getNumberNodes()
    {
        return this.nodes.size();
    }

    public int getNumberVisitedNodes()
    {
        int count=0;
        for (Integer mapKey : this.nodes.keySet())
        {
            if( (this.nodes.get(mapKey)).isVisited())
                count++;
        }

        return count;
    }
    
    /* Reset Graph to the init value (not visited */
    public void reset()
    {
        // Reset Edges
        for (int i=0;i<this.edges.getNumRows();i++)
        {
            for(int j=0;j<this.edges.getNumCols(i);j++)
            {
                Edge e = this.getEdge(i, j);
                if( e != null)
                    e.reset();
            }
        }
        
        // Reset Nodes
        for (Integer mapKey : this.nodes.keySet())
            (this.nodes.get(mapKey)).reset();
        
    }

    public void paint(Graphics g)
    {
        // Draw edges
        for (int i=0;i<this.edges.getNumRows();i++)
        {
            for(int j=0;j<this.edges.getNumCols(i);j++)
            {
               Edge e =this.edges.get(i,j);
               if(e != null)
                   e.paint(g);
            }

        }

       // Draw nodes
       Iterator it = this.nodes.entrySet().iterator();
       while(it.hasNext())
       {
           Map.Entry<Integer,Node> pair = (Map.Entry<Integer,Node>) it.next();
           ((Node )pair.getValue()).paint(g);
       }
    }

    @Override
    public String toString()
    {
        String ret="";
        ret = this.edges.toString();
        return ret;
    }
}
