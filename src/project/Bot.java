/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

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


    public Bot(int position)
    {
        this.start_position=this.position = position;
    }

    public void move(int new_position)
    {
        this.energy= this.energy-ENERGY_MOVE;
        this.position = new_position;
    }
}
