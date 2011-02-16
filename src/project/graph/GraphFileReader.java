/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author mad
 */
public class GraphFileReader {

    Graph graph;
    
    public GraphFileReader(String filename)
    {
        this.graph = new Graph();
        
        try
        {

            BufferedReader br = new BufferedReader(new FileReader(filename));

            List<String> lines = new ArrayList<String>();
            String line;

            // Reading lines
            while((line = br.readLine()) != null)
                lines.add(line);

            // Convert String matrix to int[][] matrix
            this.parse_graph(lines);
        }
        catch(Exception ex) // General exception: bad way!
        {
            System.out.println("FilReader: open file: "+ex.getMessage());
        }
    }

    private void parse_graph(List<String> lines)
    {
        int i=0;
        //for(String item: lines)
        for(int item=0;item<lines.size();item++)
        {
            StringTokenizer strtok = new StringTokenizer(lines.get(item), " ");
            String type = strtok.nextToken();

            // Node
            if(type.equals("N"))
            {

                // Read the node's id
                this.graph.addNode(Integer.parseInt(strtok.nextToken()));

                // Read the rest of the line
                while(strtok.hasMoreElements())
                    strtok.nextToken();


            }
            else if(type.equals("E"))
            {
                int id1,id2,edgeId;
                double distance;

                edgeId=Integer.parseInt(strtok.nextToken()); // read edge id

                id1 = Integer.parseInt(strtok.nextToken());
                id2 = Integer.parseInt(strtok.nextToken());
                distance = Double.parseDouble(strtok.nextToken());

                this.graph.linkNodes(edgeId,id1, id2, distance);
                while(strtok.hasMoreElements())
                    strtok.nextToken();
              
            }
        }
    }

    public Graph getGraph()
    {
        return this.graph;
    }
}
