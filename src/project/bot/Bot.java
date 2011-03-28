/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.bot;

import java.util.ArrayList;
import java.util.HashMap;
import project.graph.*;

/**
 *
 * @author mad
 */
public abstract class Bot {

    final static int ENERGY_MOVE = 0;
    final static int ENERGY_MESSAGE = 0;
    final static int ENERGY_MARKER = 0;

    int energy;
    int start_position;
    int position; // Node's id

    HashMap<Integer, Boolean> visitedNodes;

    Graph   graph;

    public Bot(Graph g,int position)
    {
        this.visitedNodes = new HashMap<Integer, Boolean>();
        this.start_position=this.position = position;
        //this.visitedNodes.add(this.start_position,true);
        this.visitedNodes.put(this.start_position, Boolean.TRUE);
        
        this.graph = g;
    }

    public void reset()
    {
        this.visitedNodes.clear();
        this.position=this.start_position;
        //this.energy= ??;
    }
    
    public abstract void move();
    //{
        //this.energy= this.energy-ENERGY_MOVE;
        //this.position = new_position;
        //this.visitedNodes.add(new_position);
    //}

}
