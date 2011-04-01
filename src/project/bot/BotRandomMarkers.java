/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import project.graph.*;

/**
 *
 * @author mad
 */
public class BotRandomMarkers extends Bot {

    public BotRandomMarkers(Graph g,int position)
    {
        super(g,position);
    }
    
    @Override
    public void decide() {
        //ArrayList<Integer> tmp = this.graph.getPossiblePathFrom(this.position);
        ArrayList<Integer> ppf = this.getBestPaths(this.graph.getEdgesMarkersCountFrom(this.position));

        /* Choose preferentially a path which has not been already visited  */
        /*ArrayList<Integer> ppf_tmp = (ArrayList<Integer>) ppf.clone();
        Iterator<Integer> it = ppf.iterator();
        ArrayList<Marker> markers;

        while(it.hasNext())
        {
            Integer id_node = it.next();
            markers = this.graph.getEdgeMarkers(this.position, id_node);

            if((this.visitedNodes.get(id_node)!=null && this.visitedNodes.get(id_node)) || markers.size()> 0)
            {
                ppf_tmp.remove(id_node);
            }
        }
        if(ppf_tmp.size()>0) // If all nodes have not been visited yet
            ppf=ppf_tmp;*/

        int lower = 0;
        int higher = ppf.size();
        int random = (int)(Math.random() * (higher-lower)) + lower;
        this.next_position=ppf.get(random);
    }

    @Override
    public void move() {

        this.graph.addEdgeMarker(this.position, this.next_position, new Marker());
        this.graph.goFromTo(this.position, this.next_position);

        this.position=this.next_position;
        this.visitedNodes.put(this.next_position, Boolean.TRUE);


    }

    private ArrayList<Integer> getBestPaths(HashMap<Integer,Integer> mks)
    {
        ArrayList<Integer> ret=new ArrayList<Integer>();
        boolean init=false;
        int smallest=0;
        int tmp;
        for (Integer mapKey : mks.keySet())
        {
            if(init==false)
            {
                smallest=mks.get(mapKey);
                init=true;
            }

            tmp=mks.get(mapKey);
            if(tmp == smallest)
            {
                ret.add(mapKey);
            }
            else if(tmp<smallest)
            {
                ret.clear();
                ret.add(mapKey);
                smallest=tmp;
            }
        }            
        return ret;
    }

}
