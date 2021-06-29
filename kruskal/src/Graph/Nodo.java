package Graph;

import Graph.GUIdata.NodeGUIdata;


import java.util.Objects;

public class Nodo extends NodeGUIdata {
    protected String name;

    public Nodo(){
        name = null;
        visited = false;
    }

    public Nodo(String name){
        this.name = name;
        visited = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo node = (Nodo) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
