/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import project.bot.Bot;
import project.graph.Graph;

/**
 *
 * @author mad
 */
public class SimulationStat extends Simulation
{
    public SimulationStat(Graph g, JPanel p)
    {
        super(g,p);
    }

    @Override
    public void run()
    {
        ArrayList<Bot> bots = this.InitRandomBot(100000);
        
        
        int count=0;
        boolean isFullyVisited=false;
        int iter=100;

        float average=0;

        for(int it=0;it<iter;it++)
        {
            count=0;
            while(!isFullyVisited)
            {
                try {
                    //Thread.sleep(1500);
                    Thread.sleep(0);
                    for(int i=0;i<bots.size();i++)
                        ((Bot) bots.get(i)).move();

                    //this.panel.repaint();
                    //this.panel.revalidate();
                    //if(count%100 == 0)
                    //    System.out.println(count);
                    count++;

                    isFullyVisited = this.graph.isGraphAllVisited();

                } catch (InterruptedException ex) {
                    Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Total number of iteration:"+count);

            this.resetGraph(bots);
            isFullyVisited=false;

            if( ((((float) it)/(it+1))) == 0.0)
                average = count;
            else
                average = average*((((float) it)/(it+1))) + ( ((float) count)/(it+1));

        }

        System.out.println("Average = "+average);
    }

    private void resetGraph(ArrayList<Bot> bots)
    {
        this.graph.reset();
        for(int i=0;i<bots.size();i++)
            bots.get(i).reset();
    }
}
