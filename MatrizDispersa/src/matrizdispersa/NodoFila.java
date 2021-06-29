/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizdispersa;

/**
 *
 * @author Jeferson Jimenez
 */
public class NodoFila {

    private int fila;
    private int valor;
    private NodoFila siguienteElemento;

    public NodoFila(int fila, int valor) {
        this.fila = fila;
        this.valor = valor;
        siguienteElemento = null;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoFila getSiguienteElemento() {
        return siguienteElemento;
    }

    public void setSiguienteElemento(NodoFila siguienteElemento) {
        this.siguienteElemento = siguienteElemento;
    }

    public String obtenerNodo() {
        return "" + valor + "";
    }

    @Override
    public String toString() {
        return "Nodo Fila [Fila# " + fila + ", Valor= " + valor + ", Siguiente Fila: " + ((siguienteElemento != null) ? siguienteElemento.getValor() : null) + "]";
    }

}
