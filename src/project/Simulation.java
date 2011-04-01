/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.ArrayList;
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

    protected final static int INIT_POSITION=1;
    
    protected Graph graph;
    protected JPanel panel;
    public Simulation(Graph g,JPanel p)
    {
        this.graph = g;
        this.panel = p;
    }

    @Override
    public void run()
    {
        //Bot bot = new BotRandom(this.graph,1);
        ArrayList<Bot> bots = this.InitRandomBot(5);
        int count=0;
        boolean isFullyVisited=false;
        while(!isFullyVisited)
        {
            try {
                //Thread.sleep(1500);
                Thread.sleep(100);
                for(int i=0;i<bots.size();i++)
                    ((Bot) bots.get(i)).decide();

                for(int i=0;i<bots.size();i++)
                    ((Bot) bots.get(i)).move();

                this.panel.repaint();
                this.panel.revalidate();
                if(count%260 == 0)
                {
                    System.out.println(count);
                    //this.graph.reset();
                }
                count++;

                isFullyVisited = this.graph.isGraphAllVisited();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Total number of iteration:"+count);
    }

    protected ArrayList<Bot> InitRandomBot(int count)
    {
        ArrayList<Bot> ret = new ArrayList<Bot>();

        for(int i=0;i<count;i++)
            ret.add(new BotRandom(this.graph,Simulation.INIT_POSITION));

        return ret;
    }
}
