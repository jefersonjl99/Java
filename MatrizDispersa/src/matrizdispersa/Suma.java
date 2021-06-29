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
public class Suma {

    private final Matriz A, B;
    private final Matriz resultado;

    public Suma(Matriz A, Matriz B) {
        this.resultado = new Matriz();
        this.A = A;
        this.B = B;
        Sumar(A, B);
    }

    public void Sumar(Matriz A, Matriz B) {
        int fila_actual, columna_actual, suma, columnas_iguales, filas_iguales;

        for (NodoColumna i = A.getCabeza(); i != null; i = i.getSiguienteElemento()) {

            columnas_iguales = 0;

            columna_actual = i.getColumna();

            for (NodoColumna k = B.getCabeza(); k != null; k = k.getSiguienteElemento()) {

                if (i.getColumna() == k.getColumna()) {

                    columnas_iguales = 1;

                    for (NodoFila j = i.getElementoAbajo(); j != null; j = j.getSiguienteElemento()) {

                        filas_iguales = 0;

                        fila_actual = j.getFila();

                        for (NodoFila l = k.getElementoAbajo(); l != null; l = l.getSiguienteElemento()) {

                            int a = 0, b = 0;

                            if (l.getFila() == j.getFila()) {
                                filas_iguales = 1;
                                a = j.getValor();
                                b = l.getValor();
                                suma = a + b;
                                resultado.insertar(fila_actual, columna_actual, suma);
                                break;
                            }

                        }
                        if (filas_iguales == 0) {
                            for (NodoFila l = k.getElementoAbajo(); l != null; l = l.getSiguienteElemento()) {
                                suma = j.getValor();
                                columna_actual = i.getColumna();
                                fila_actual = j.getFila();
                                resultado.insertar(fila_actual, columna_actual, suma);
                            }
                        }
                    }
                    break;
                }
            }
            if (columnas_iguales == 0) {
                for (NodoFila j = i.getElementoAbajo(); j != null; j = j.getSiguienteElemento()) {
                    suma = j.getValor();
                    columna_actual = i.getColumna();
                    fila_actual = j.getFila();
                    resultado.insertar(fila_actual, columna_actual, suma);
                }
            }
        }
        for (NodoColumna i = B.getCabeza(); i != null; i = i.getSiguienteElemento()) {

            columnas_iguales = 0;

            columna_actual = i.getColumna();

            for (NodoColumna k = A.getCabeza(); k != null; k = k.getSiguienteElemento()) {

                if (i.getColumna() == k.getColumna()) {

                    columnas_iguales = 1;

                    for (NodoFila j = i.getElementoAbajo(); j != null; j = j.getSiguienteElemento()) {

                        filas_iguales = 0;

                        fila_actual = j.getFila();

                        for (NodoFila l = k.getElementoAbajo(); l != null; l = l.getSiguienteElemento()) {

                            int a = 0, b = 0;

                            if (l.getFila() == j.getFila()) {
                                filas_iguales = 1;
                                a = j.getValor();
                                b = l.getValor();
                                suma = a + b;
                                resultado.insertar(fila_actual, columna_actual, suma);
                                break;
                            }

                        }
                        if (filas_iguales == 0) {
                            for (NodoFila l = k.getElementoAbajo(); l != null; l = l.getSiguienteElemento()) {
                                suma = j.getValor();
                                columna_actual = i.getColumna();
                                fila_actual = j.getFila();
                                resultado.insertar(fila_actual, columna_actual, suma);
                            }
                        }
                    }
                    break;
                }
            }
            if (columnas_iguales == 0) {
                for (NodoFila j = i.getElementoAbajo(); j != null; j = j.getSiguienteElemento()) {
                    suma = j.getValor();
                    columna_actual = i.getColumna();
                    fila_actual = j.getFila();
                    resultado.insertar(fila_actual, columna_actual, suma);
                }
            }
        }

        resultado.print();
    }

    public Matriz getA() {
        return A;
    }

    public Matriz getB() {
        return B;
    }

    public Matriz getResultado() {
        return resultado;
    }

}
