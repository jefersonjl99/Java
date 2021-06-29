package Algorithm;


import Graph.Nodo;
import GUI.Grafo;
import Graph.Arista;
import GUI.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphAnalyzer implements Alghoritms {
    @Override
    public Grafo KruskalAnalyze(Grafo graph){
        GraphFactory factoryGraph = new GraphFactory();

        ArrayList<Arista> result = new ArrayList<Arista>();

        Map<Integer, ArrayList<Nodo>> Unions = new HashMap<Integer, ArrayList<Nodo>>();

        graph.getEdgeList().sort(new Arista.EdgeComparator());

        int i = 0;

        for (Arista e : graph.getEdgeList()){
            if ((e.getFirst().getUnionIndex() == null) && (e.getSecond().getUnionIndex() == null)){
                result.add(e);

                Unions.put(i, new ArrayList<Nodo>());
                Unions.get(i).add(e.getFirst());
                Unions.get(i).add(e.getSecond());

                e.getFirst().setUnionIndex(i);
                e.getSecond().setUnionIndex(i);

                ++i;
            }

            else if((e.getFirst().getUnionIndex() != null) && (e.getSecond().getUnionIndex() == null)){
                result.add(e);

                Unions.get(e.getFirst().getUnionIndex()).add(e.getSecond());

                e.getSecond().setUnionIndex(e.getFirst().getUnionIndex());
            }

            else if((e.getFirst().getUnionIndex() == null) && (e.getSecond().getUnionIndex() != null)){
                result.add(e);

                Unions.get(e.getSecond().getUnionIndex()).add(e.getFirst());

                e.getFirst().setUnionIndex(e.getSecond().getUnionIndex());
            }

            else if (e.getFirst().getUnionIndex() == e.getSecond().getUnionIndex()) {
                continue;
            }

            else{
                result.add(e);

                for (Nodo n : Unions.get(e.getFirst().getUnionIndex())) {
                    Unions.get(e.getSecond().getUnionIndex()).add(n);

                    n.setUnionIndex(e.getSecond().getUnionIndex());
                }

            }

        }

        for (Nodo k : graph.getNodeList()){
            k.setUnionIndex(null);
        }

        for (Nodo k:graph.getNodeList()){
            k.setVisited(false);
        }

        return factoryGraph.getGraph(result);

    };

}