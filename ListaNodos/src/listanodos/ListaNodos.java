/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listanodos;

import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Jimenez
 */
public class ListaNodos {

    private Nodo raiz;

    public static void main(String[] ar) {
        ListaNodos lista = new ListaNodos();
        int rta;
        int entrada;
        do {
            entrada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero a agregar: "));
            rta = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 si desea agregar mas elementos: "));
            lista.insertar(entrada);
            lista.imprimir();
        } while (rta == 1);
        lista.imprimir();
    }

    public ListaNodos() {
        raiz = null;
    }

    public void insertar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.elemento = x;
        if (raiz == null) {
            nuevo.sig = null;
            raiz = nuevo;
        } else {
            nuevo.sig = raiz;
            raiz = nuevo;
        }
    }

    public void imprimir() {
        Nodo reco = raiz;
        System.out.println("Listado de todos los elementos de la lista.");
        while (reco != null) {
            System.out.print(reco.elemento + "-");
            reco = reco.sig;
        }
        System.out.println("null");
    }

}

class Nodo {

    int elemento;
    Nodo sig;
}
