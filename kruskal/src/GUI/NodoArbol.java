/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author juanc
 */
public class NodoArbol {
    NodoArbol hijoIzquierda, hijoDerecha;
    int clave;
    
    NodoArbol(int dato){
        this.hijoDerecha = null;
        this.hijoIzquierda = null;
        this.clave = dato;
    }
    
}
