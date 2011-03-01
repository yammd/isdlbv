/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.MatchResult;

/**
 *
 * @author mad
 */
public class GraphFileReader {

    Graph graph;
    
    public GraphFileReader(String filename,String filenameGui)
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

            br.close();
            
            // Convert String matrix to int[][] matrix
            this.parse_graph(lines);

            /* Reading Graphical information */
            this.parse_gui(filenameGui);
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

    private void parse_gui(String filename) {
        Scanner scan;
        try
        {
            scan = new Scanner(new File(filename));

           //String input="vertex 169 129 1\nedge 169 129 190 318 1 2 190.0";
           //Scanner s = new Scanner(input);

           while(scan.hasNext())
           {
                MatchResult result;
                try
                {
                   scan.findInLine("vertex (\\d+) (\\d+) (\\d+)");
                   result = scan.match();
                   Node node = this.graph.getNode(Integer.parseInt(result.group(3)));
                   node.setGraphic(Integer.parseInt(result.group(1)), Integer.parseInt(result.group(2)));
                }
                catch(Exception NoNodeFound)
                {
                    try
                    {
                        scan.findInLine("edge (\\d+) (\\d+) (\\d+) (\\d+) (\\d+) (\\d+) (\\d+(?:\\.\\d*)?)");
                        result = scan.match();
                        int id1 = Integer.parseInt(result.group(5));
                        int id2 = Integer.parseInt(result.group(6));
                        
                        Edge edge = this.graph.getEdge(id1, id2);
                        int x1,x2,y1,y2;
                        float weight;

                        x1 = Integer.parseInt(result.group(1));
                        x2 = Integer.parseInt(result.group(2));
                        y1 = Integer.parseInt(result.group(3));
                        y2 = Integer.parseInt(result.group(4));

                        weight = Float.parseFloat(result.group(7));
                        edge.setGraphic(x1, x2, y1, y2);
                    }
                    catch(Exception NoEdgeFound)
                    {
                        
                    }
                }

                scan.nextLine();
            }

           scan.close();
            
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(GraphFileReader.class.getName()).log(Level.INFO, null, ex);
        }
    }
    
    public Graph getGraph()
    {
        return this.graph;
    }

}
