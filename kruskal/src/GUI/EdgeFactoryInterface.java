package GUI;

import Graph.Nodo;
import Graph.Arista;

public abstract class EdgeFactoryInterface {
    public abstract Arista getEdge();

    public abstract Arista getEdge(Nodo first, Nodo second, Integer weight);

}
