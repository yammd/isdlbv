/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import project.graph.Graph;
import project.bot.*;

/**
 *
 * @author mad
 */
public class Simulation extends Thread {

    Graph graph;
    JPanel panel;
    public Simulation(Graph g,JPanel p)
    {
        this.graph = g;
        this.panel = p;
    }

    @Override
    public void run()
    {
        Bot bot = new BotRandom(this.graph,1);
        int count=0;
        while(true)
        {
            try {
                //Thread.sleep(1500);
                Thread.sleep(100);
                bot.move();
                this.panel.repaint();
                this.panel.revalidate();
                if(count%200 == 0)
                    System.out.println(count);
                count++;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*private ArrayList<Bot> InitBot(int count)
    {
        ArrayList<Bot> ret = new ArrayList()
    }*/
}
