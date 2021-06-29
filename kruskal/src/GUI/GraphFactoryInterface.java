package GUI;


import Graph.Nodo;
import Graph.Arista;
import java.util.ArrayList;

public abstract class GraphFactoryInterface {
    public abstract Grafo getGraph();

    public abstract Grafo getGraph(ArrayList<Arista> edgeList, ArrayList<Nodo> nodeList);

    public abstract Grafo getGraph(ArrayList<Arista> edgeList);
}
