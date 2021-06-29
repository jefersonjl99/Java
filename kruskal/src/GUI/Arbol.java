/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.NodoArbol;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanc
 */
class NodoDibujo {

    int clave;
    NodoDibujo hijoIzquierda, hijoDerecha;
    NodoDibujo padre;

    NodoDibujo(int d) {
        clave = d;
        hijoIzquierda = null;
        hijoDerecha = null;
    }
}

class Arbol {

    static NodoDibujo raiz;
    private int[] Heap;
    private int size;
    private int maxsize;
    public String salida = "";

    private static final int FRONT = 1;

    public Arbol(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    public NodoDibujo getRaiz() {
        return raiz;
    }

    public int getDato() {
        return raiz.clave;
    }

    public Arbol() {

    }

    // Function to return the position of 
    // the parent for the node currently 
    // at pos 
    private int parent(int pos) {
        return pos / 2;
    }

    // Function to return the position of the 
    // left child for the node currently at pos 
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Function to return the position of 
    // the right child for the node currently 
    // at pos 
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Function that returns true if the passed 
    // node is a leaf node 
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Function to swap two nodes of the heap 
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to heapify the node at pos 
    private void minHeapify(int pos) {

        // If the node is a non-leaf node and greater 
        // than any of its child 
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {

                // Swap with the left child and heapify 
                // the left child 
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } // Swap with the right child and heapify 
                // the right child 
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // Function to insert a node into the heap 
    public void insert(int element) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    NodoDibujo inserta(NodoDibujo nodo, int clave, int lado) {
        System.out.println("esta insertando " + clave);
        if (nodo == null) {
            return (new NodoDibujo(clave));
        }

        switch (lado) {
            case 1:
                nodo.hijoIzquierda = inserta(nodo.hijoIzquierda, clave, lado);
                System.out.println("padre: ");
                break;
            case 2:
                nodo.hijoDerecha = inserta(nodo.hijoDerecha, clave, lado);
                break;
            default:
                return nodo;
        }

        return nodo;
    }

    List<String> lista = new ArrayList<String>();
    static NodoArbol nodox;

    // Function to print the contents of the heap 
    public void print() {
        Arbol arbol = new Arbol();

        lista.add(Heap[1] + "," + 0 + "," + 0);
        arbol.raiz = inserta(raiz, Heap[1], 0);
        for (int i = 1; i <= size / 2; i++) {

            System.out.print(" LLAVE : " + Heap[i]
                    + " HIJO IZQUIERDO : " + Heap[2 * i]
                    + " HIJO DERECHO :" + Heap[2 * i + 1]);
            arbol.raiz = inserta(raiz, Heap[2 * i], 1);

            arbol.raiz = inserta(raiz, Heap[2 * i + 1], 2);

            lista.add(Heap[2 * i] + "," + 1 + "," + Heap[i]);
            lista.add(Heap[2 * i + 1] + "," + 2 + "," + Heap[i]);
            System.out.println();
        }

        //  String []rai = lista.get(0).split(",");
        // nodox = new NodoArbol(Integer.parseInt(rai[0]));
        // inserta(nodox, Integer.parseInt(rai[0]), 0);
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("texto de michimbo prueba " + lista.get(i));
            String[] rai2 = lista.get(i).split(",");
            System.out.println("clave: " + rai2[0] + " lado: " + rai2[1] + " papa: " + rai2[2]);
//            arbol.raiz = inserta(raiz, Integer.parseInt(rai2[0]), Integer.parseInt(rai2[1]), Integer.parseInt(rai2[2]));
//            if(i==0){
//                arbol.raiz = inserta(raiz, Integer.parseInt(rai2[0]), Integer.parseInt(rai2[1]),Integer.parseInt(rai2[2]));
//            }else if(Integer.parseInt(rai2[2])==Heap[i]){
//                arbol.raiz = inserta(raiz, Integer.parseInt(rai2[0]), Integer.parseInt(rai2[1]), Integer.parseInt(rai2[2]));
//            }else{
//                
//            }

            // inserta(nodox2, Integer.parseInt(rai[0]), Integer.parseInt(rai[1]));
            System.out.println();
        }

        this.raiz = arbol.raiz;
        verArbol(raiz);
        for (int i = 1; i <= size / 2; i++) {
            salida = "" + Heap[i] + "->" + Heap[2 * i] + "\n" + Heap[i] + "->" + Heap[2 * i + 1];

        }
        System.out.println(salida);
    }

    public void verArbol(NodoDibujo raiza) {

        System.out.println("aaaaaaaaaaaaaaaa " + raiza.clave);
    }

    public NodoArbol getNodo() {

        return nodox;
    }

    // Function to build the min heap using 
    // the minHeapify 
    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    // Function to remove and return the minimum 
    // element from the heap 
    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    // Driver code 
    public void añadirDatos(String[][] arb) {
        Arbol minHeap = new Arbol(arb.length + 1);
        System.out.println(arb.length);
        for (int i = 0; i < arb.length; i++) {
            minHeap.insert(Integer.parseInt(arb[i][2]));
        }

        /* 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
        minHeap.minHeap(); 
         */
        minHeap.print();
        //  System.out.println("The Min val is " + minHeap.remove()); 
    }
}
