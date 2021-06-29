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
public class NodoColumna {

    private int columna;
    private NodoColumna siguienteElemento;
    private NodoFila elementoAbajo;

    public NodoColumna(int valor) {
        this.columna = valor;
        siguienteElemento = null;
        elementoAbajo = null;
    }

    public NodoFila getElementoAbajo() {
        return elementoAbajo;
    }

    public void setElementoAbajo(NodoFila elementoAbajo) {
        this.elementoAbajo = elementoAbajo;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public NodoColumna getSiguienteElemento() {
        return siguienteElemento;
    }

    public void setSiguienteElemento(NodoColumna siguienteElemento) {
        this.siguienteElemento = siguienteElemento;
    }

    public String obtenerNodo() {
        return "" + columna + "";
    }

    @Override
    public String toString() {
        return "Nodo Columna [Columna# " + columna + ", Siguiente Columna= " + ((siguienteElemento != null) ? siguienteElemento.getColumna(): null) + ", Valor Fila Inferior= " + ((elementoAbajo != null) ? elementoAbajo.getValor() : null) + "]";
    }

}
