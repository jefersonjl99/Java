package Graph;

import java.util.Comparator;
import java.util.Objects;

public class Arista {
    private Nodo first;
    private Nodo second;
    private Integer weight;

    public Arista(){
        first = null;

        second = null;

        weight = null;
    }

    public Arista(Nodo first, Nodo second, Integer weight){
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    public void setSecond(Nodo second) {
        this.second = second;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }

    public Nodo getSecond() {
        return second;
    }

    public Nodo getFirst() {
        return first;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    static public class EdgeComparator implements Comparator<Arista> {

        @Override
        public int compare(Arista o1, Arista o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arista edge = (Arista) o;
        return Objects.equals(first, edge.first) &&
                Objects.equals(second, edge.second) &&
                Objects.equals(weight, edge.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, weight);
    }
}
