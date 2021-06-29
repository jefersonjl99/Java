/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadoblementeenlazada;

/**
 *
 * @author Jeferson Jimenez
 */
public class Lista {

    private Nodo cola;
    private Nodo cabeza;

    public void insertarFinal(String valor) {
        Nodo nodo = new Nodo(valor);
        if (cola == null && cabeza == null) {
            cola = nodo;
            cabeza = nodo;
        } else {
            cola.setSiguienteElemento(nodo);
            nodo.setAnteriorElemento(cola);
            cola = nodo;
        }
    }

    public void insertarPrimero(String valor) {
        Nodo nodo = new Nodo(valor);
        if (cola == null && cabeza == null) {
            cola = nodo;
            cabeza = nodo;
        } else {
            nodo.setSiguienteElemento(cabeza);
            cabeza.setAnteriorElemento(nodo);
            cabeza = nodo;
        }
    }

    public Nodo obtenerNodoHaciaAtras(int indice) {
        Nodo salida=cola;
        for (int i = 0; i <indice; i ++) {
            salida=salida.getAnteriorElemento();
        }
        salida.toString();
        return salida;
    }

    public Nodo obtenerNodoHaciaAdelante() {
        return null;
    }

    public void print() {
        for (Nodo i = cabeza; i != null; i = i.getSiguienteElemento()) {
            System.out.printf("%s\t", i.toString());
        }
        System.out.println();
    }
    
    public String obtenerLista() {
        String s = "";
        for (Nodo i = cabeza; i != null; i = i.getSiguienteElemento()) {
            s+=i.obtenerNodo();
        }
        return s;
    }

}
