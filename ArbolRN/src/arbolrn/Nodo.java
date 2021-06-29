/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolrn;

/**
 *
 * @author Jeferson Jimenez
 */
class Nodo {

    int clave;//dato a almacenar
    String nombre;
    Nodo padre;//optimizar proceso agregando este atributo
    Nodo hijoIzquierdo;
    Nodo hijoDerecho;
    int color;

    public Nodo() {
    }

    Nodo(int clave) {
        this.clave = clave;
        this.nombre = "";
        hijoIzquierdo = hijoDerecho = null;
    }

    Nodo(int clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
        hijoIzquierdo = hijoDerecho = null;
    }

}
