package GUI;

import Graph.Nodo;
import Graph.Arista;

public class EdgeFactory extends EdgeFactoryInterface{
    @Override
    public Arista getEdge(){
        return new Arista();
    }


    @Override
    public Arista getEdge(Nodo first, Nodo second, Integer weight)
    {
        return new Arista(first, second, weight);
    }
}
