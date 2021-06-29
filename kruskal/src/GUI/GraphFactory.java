package GUI;


import Graph.Nodo;
import Graph.Arista;
import java.util.ArrayList;

public class GraphFactory extends GraphFactoryInterface {
    @Override
    public Grafo getGraph(){
        return new Grafo();
    }

    @Override
    public Grafo getGraph(ArrayList<Arista> edgeList, ArrayList<Nodo> nodeList){
        return new Grafo(edgeList, nodeList);
    }

    @Override
    public Grafo getGraph(ArrayList<Arista> edgeList) {
        return new Grafo(edgeList);
    }

}
