/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.ArrayList;

/**
 *
 * @author mad
 */
public class Bot {

    final static int ENERGY_MOVE = 0;
    final static int ENERGY_MESSAGE = 0;
    final static int ENERGY_MARKER = 0;

    int energy;
    int start_position;
    int position; // Node's id

    ArrayList<Integer> visitedNodes;

    public Bot(int position)
    {
        this.visitedNodes = new ArrayList<Integer>();
        this.start_position=this.position = position;
        this.visitedNodes.add(this.start_position);
    }

    public void move(int new_position)
    {
        this.energy= this.energy-ENERGY_MOVE;
        this.position = new_position;
        this.visitedNodes.add(new_position);
    }

    public void moveRandomly()
    {
        
    }
}
