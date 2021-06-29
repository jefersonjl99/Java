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
public class Matriz {

    private NodoColumna cabeza = null;
    private String nombre;
    private int filas, columnas;

    public Matriz() {
        this.nombre = "";
    }

    public Matriz(String nombre) {
        this.nombre = nombre;
    }

    public Matriz(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
    }

    public void insertar(int fila, int columna, int valor) {

        if (valor != 0 && fila > 0 && columna > 0) {
            NodoColumna nueva_col = new NodoColumna(columna);
            if (cabeza == null) {
                cabeza = nueva_col;
            } else {
                if (columna < cabeza.getColumna()) {
                    nueva_col.setSiguienteElemento(cabeza);
                    cabeza = nueva_col;
                } else {
                    NodoColumna recorrido = cabeza;
                    NodoColumna anterior = cabeza;
                    while (columna > recorrido.getColumna() && recorrido.getSiguienteElemento() != null) {
                        anterior = recorrido;
                        recorrido = recorrido.getSiguienteElemento();
                    }
                    if (columna == recorrido.getColumna()) {
                        nueva_col = recorrido;
                    } else if (columna > recorrido.getColumna()) {
                        recorrido.setSiguienteElemento(nueva_col);
                    } else if (columna < recorrido.getColumna()) {
                        nueva_col.setSiguienteElemento(recorrido);
                        anterior.setSiguienteElemento(nueva_col);
                    }
                }
            }

            NodoFila nueva_fila = new NodoFila(fila, valor);
            NodoFila cabeza_fila = nueva_col.getElementoAbajo();
            if (cabeza_fila == null) {
                nueva_col.setElementoAbajo(nueva_fila);
            } else {
                if (fila < cabeza_fila.getFila()) {
                    nueva_fila.setSiguienteElemento(cabeza_fila);
                    nueva_col.setElementoAbajo(nueva_fila);
                } else {
                    NodoFila recorrido = cabeza_fila;
                    NodoFila anterior = cabeza_fila;
                    while (fila > recorrido.getFila() && recorrido.getSiguienteElemento() != null) {
                        anterior = recorrido;
                        recorrido = recorrido.getSiguienteElemento();
                    }
                    if (fila == recorrido.getFila()) {
                        recorrido.setFila(nueva_fila.getFila());
                        recorrido.setValor(nueva_fila.getValor());
                    } else if (fila > recorrido.getFila()) {
                        recorrido.setSiguienteElemento(nueva_fila);
                    } else if (fila < recorrido.getFila()) {
                        nueva_fila.setSiguienteElemento(recorrido);
                        anterior.setSiguienteElemento(nueva_fila);
                    }
                }

            }
        }
    }

    public int[] obtenerTamañoMatriz() {
        int[] tam = new int[2];
        int fila , columna = 0;
        for (NodoColumna i = cabeza; i != null; i = i.getSiguienteElemento()) {
            fila = 0;
            for (NodoFila j = i.getElementoAbajo(); j != null; j = j.getSiguienteElemento()) {
                fila++;
            }
            columna++;
            if (fila > tam[0]) {
                tam[0] = fila;
            }
            tam[1] = columna;
        }

        return tam;
    }

    public void print() {
        System.out.println("\nMatriz " + nombre + " (" + (this.filas) + " x " + this.columnas + ")");
        if (this.cabeza != null) {
            for (NodoColumna i = cabeza; i != null; i = i.getSiguienteElemento()) {
                System.out.printf("%s\t", i.toString());
                for (NodoFila j = i.getElementoAbajo(); j != null; j = j.getSiguienteElemento()) {
                    System.out.printf("%s\t", j.toString());
                }
                System.out.println("");
            }
            System.out.println();
        } else {
            System.out.println("null");
        }
    }

    public void clear() {
        this.cabeza = null;
        this.filas = 0;
        this.columnas = 0;
    }

    public NodoColumna getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoColumna cabeza) {
        this.cabeza = cabeza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

}
