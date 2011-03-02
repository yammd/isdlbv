/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.bot;

import java.util.ArrayList;
import java.util.Iterator;
import project.graph.*;

/**
 *
 * @author mad
 */
public class BotRandom extends Bot {

    public BotRandom(Graph g,int position)
    {
        super(g,position);
    }
    
    @Override
    public void move() {
        ArrayList<Integer> ppf = this.graph.getPossiblePathFrom(this.position);

        /* Choose preferentially a path which has not been already visited  */
        ArrayList<Integer> ppf_tmp = (ArrayList<Integer>) ppf.clone();
        Iterator<Integer> it = ppf.iterator();
        while(it.hasNext())
        {
            Integer id_node = it.next();
            if(this.visitedNodes.get(id_node)!=null && this.visitedNodes.get(id_node))
            {
                ppf_tmp.remove(id_node);
            }
        }
        if(ppf_tmp.size()>0) // If all nodes have not been visited yet
            ppf=ppf_tmp;

        int lower = 0;
        int higher = ppf.size();
        int random = (int)(Math.random() * (higher-lower)) + lower;

        this.graph.goFromTo(this.position, ppf.get(random));

        this.position=ppf.get(random);
        this.visitedNodes.put(ppf.get(random), Boolean.TRUE);

    }
}
