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
public class Nodo {

    private Nodo anteriorElemento;
    private String valor;
    private Nodo siguienteElemento;

    public Nodo(String value) {
        this.valor = value;
    }

    public Nodo() {
        this.valor = "";
    }

    public Nodo getAnteriorElemento() {
        return anteriorElemento;
    }

    public void setAnteriorElemento(Nodo anteriorElemento) {
        this.anteriorElemento = anteriorElemento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Nodo getSiguienteElemento() {
        return siguienteElemento;
    }

    public void setSiguienteElemento(Nodo siguienteElemento) {
        this.siguienteElemento = siguienteElemento;
    }

    public String obtenerNodo() {
        return "" + valor + "";
    }

    @Override
    public String toString() {
        return "Nodo [valor=" + valor + ", Siguiente Elemento=" + ((siguienteElemento != null) ? siguienteElemento.getValor() : null) + ", Anterior Elemento=" + ((anteriorElemento != null) ? anteriorElemento.getValor() : null) + "]";
    }

}
