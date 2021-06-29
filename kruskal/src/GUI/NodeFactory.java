package GUI;

import Graph.Nodo;

public class NodeFactory extends NodeFactoryInterface {

    @Override
    public Nodo getNode(){
        return new Nodo(String.valueOf(name++));
    }

    @Override
    public Nodo getNode(String name){
        return new Nodo(name);
    }
}
