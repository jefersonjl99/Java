package GUI;

import Graph.Nodo;

public abstract class NodeFactoryInterface {
    protected char name = 'a';

    public abstract Nodo getNode();
    public abstract Nodo getNode(String name);
}
