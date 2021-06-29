package GUI;

import Graph.Arista;
import GUI.EdgeFactory;
import GUI.GraphFactory;
import GUI.NodeFactory;
import Graph.Nodo;

import javax.swing.*;
import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

import java.util.ArrayList;

public class Grafo {

    private ArrayList<Nodo> listaNodos;
    private ArrayList<Arista> listaAristas;
    public String[][] aristas;

    public Grafo(){
        listaNodos = new ArrayList<Nodo>();
        listaAristas = new ArrayList<Arista>();
    }

    public Grafo(ArrayList<Arista> edgeList, ArrayList<Nodo> nodeList){
        this.listaAristas = edgeList;
        this.listaNodos = nodeList;
    }

    public Grafo(ArrayList<Arista> edgeList){
        this.listaAristas = edgeList;

        this.listaNodos = new ArrayList<Nodo>();

        for (Arista e : edgeList){
            if (!listaNodos.contains(e.getFirst())){
                listaNodos.add(e.getFirst());
            }


            if (!listaNodos.contains(e.getSecond())){
                listaNodos.add(e.getSecond());
            }
        }
    }
    
    public String[][] numeroAristas(){
        aristas=new String[listaAristas.size()][3];
        int i=0;
         for(Arista e : listaAristas){
             aristas[i][0]=e.getFirst().getName();
             aristas[i][1]=e.getSecond().getName();
             aristas[i][2]=e.getWeight()+"";
             i++;
            }
         
        /*
         for(int k=0;k<edgeList.size();k++){
             for(int j=0;j<3;j++){
                 System.out.print(aristas[k][j]);
             }
             System.out.println(" ");
         }
*/
         return aristas;
    }
    
    public void setEdgeList(ArrayList<Arista> edgeList) {
        this.listaAristas = edgeList;
    }

    public ArrayList<Arista> getEdgeList() {
        return listaAristas;
    }

    public void setNodeList(ArrayList<Nodo> nodeList) {
        this.listaNodos = nodeList;
    }

    public ArrayList<Nodo> getNodeList() {
        for(Arista e : listaAristas){
                String toPut = e.getFirst().getName() + " " + e.getSecond().getName() + " "
                        + e.getWeight() + "\n";

                //System.out.println(toPut);
            }
        return listaNodos;
    }

    public ArrayList<Nodo> adjacentNodes(Nodo e){
        ArrayList<Nodo> result = new ArrayList<Nodo>();

        for (Arista edge : listaAristas){
            if (edge.getFirst() == e) {
                result.add(edge.getSecond());
            }

            if  (edge.getSecond() == e) {
                result.add(edge.getFirst());
            }
        }

        return result;
    }

    public boolean isConnected(){
        Queue<Nodo> currentQueue = new LinkedList<Nodo>();
        Nodo current = listaNodos.get(0);

        ArrayList<Nodo> adjacentToCurrent = adjacentNodes(current);

        for(Nodo e : adjacentToCurrent){
            if (!e.isVisited()){
                currentQueue.add(e);
            }
        }

        current.setVisited(true);

        while(!currentQueue.isEmpty()){
            current = currentQueue.poll();

            adjacentToCurrent = adjacentNodes(current);

            for(Nodo e : adjacentToCurrent){
                if (!e.isVisited()){
                    currentQueue.add(e);
                }
            }

            current.setVisited(true);
        }

        for(Nodo e : listaNodos) {
            if (!e.isVisited()) {
                return false;
            }
        }

        return true;
    }

    public void save(String filename){

        BufferedWriter writer;
        NodeFactory factoryNode = new NodeFactory();
        EdgeFactory factoryEdge = new EdgeFactory();
        GraphFactory factoryGraph = new GraphFactory();

        try{
            writer = new BufferedWriter(new FileWriter(filename));

            for(Arista e : listaAristas){
                String toPut = e.getFirst().getName() + " " + e.getSecond().getName() + " "
                        + e.getWeight() + "\n";

                writer.write(toPut);
            }

            for(Nodo e : listaNodos){
                if(adjacentNodes(e).size() == 0){
                    String toPut = e.getName() + "\n";

                    writer.write(toPut);
                }
            }

            writer.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Couldn't open/read file");

            return;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Couldn't open/read file");

            return;
        } finally {}

    }

    public static Grafo load(String filename){
        BufferedReader reader;
        NodeFactory factoryNode = new NodeFactory();
        EdgeFactory factoryEdge = new EdgeFactory();
        GraphFactory factoryGraph = new GraphFactory();

        try{
            reader = new BufferedReader(new FileReader(filename));

            ArrayList<Arista> edgeList = new ArrayList<Arista>();

            String line = reader.readLine();

            ArrayList<Nodo> originalNodes = new ArrayList<Nodo>();

            while(line != null){
                String [] parsed = line.split("[\\s+]");

                Nodo first = null;
                Nodo second = null;

                for(Nodo n : originalNodes){
                    if (n.getName().equals(parsed[0])){
                        first = n;
                    }

                    if (n.getName().equals(parsed[1])){
                        second = n;
                    }
                }

                if(first == null){
                    first = (factoryNode).getNode(parsed[0]);
                    originalNodes.add(first);
                }


                if(second == null){
                    second = factoryNode.getNode(parsed[1]);
                    originalNodes.add(second);
                }

                edgeList.add(factoryEdge.getEdge(first, second, Integer.parseInt(parsed[2])));

                line = reader.readLine();
            }

            Grafo result = factoryGraph.getGraph(edgeList);

            double angle = 0;

            int[] x = new int[result.getNodeList().size()];
            int[] y = new int[result.getNodeList().size()];

            for(int i = 0 ; i < result.getNodeList().size()  ;++i)
            {
                angle = i * (360/result.getNodeList().size());

                x[i] = (int) (550 + 200 * Math.cos(Math.toRadians(angle)));
                y[i] = (int) (250 + 200 * Math.sin(Math.toRadians(angle)));

            }

            int i = 0;

            for(Nodo e : result.getNodeList())
            {
                e.setX(x[i]);
                e.setY(y[i]);

                i++;
            }

            return result;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Couldn't open/read file");

            return null;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Couldn't open/read file");

            return null;
        } finally {}

    }
}