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
public class Multiplicacion {

    private final Matriz A, B;
    private final Matriz resultado;

    public Multiplicacion(Matriz A, Matriz B) {
        this.resultado = new Matriz();
        this.A = A;
        this.B = B;
        Multiplicar(A, B);
    }

    public void Multiplicar(Matriz A, Matriz B, Matriz resultado) {
        int fila_actual_b = 0, fila_actual_a = 0, columna_actual, suma, columnas_iguales, filas_iguales, multiplicacion = 0, a, b;
        NodoFila nodo_fila_actual = null;
        boolean tomado = false;

        for (NodoColumna i = B.getCabeza(); i != null; i = i.getSiguienteElemento()) {

            columna_actual = i.getColumna();
            suma = 0;

            for (NodoFila j = i.getElementoAbajo(); j != null; j = j.getSiguienteElemento()) {

                fila_actual_b = j.getFila();
                a = j.getValor();

                do {
                    for (NodoColumna k = A.getCabeza(); k != null; k = k.getSiguienteElemento()) {

                        if (!tomado) {
                            nodo_fila_actual = k.getElementoAbajo();
                            fila_actual_a = k.getElementoAbajo().getFila();
                            b = k.getElementoAbajo().getValor();
                            multiplicacion = a * b;
                            tomado = true;
                            break;
                        } else {
                            for (NodoFila l = k.getElementoAbajo(); l != null; l = l.getSiguienteElemento()) {
                                if (l.getFila() == nodo_fila_actual.getFila()) {
                                    b = k.getElementoAbajo().getValor();
                                    multiplicacion = a * b;
                                    break;
                                }
                            }
                        }
                    }
                    suma += multiplicacion;
                    if (nodo_fila_actual.getSiguienteElemento() != null) {
                        nodo_fila_actual = nodo_fila_actual.getSiguienteElemento();
                    } else {
                        nodo_fila_actual = null;
                    }
                } while (nodo_fila_actual != null);

            }
            resultado.insertar(fila_actual_a, columna_actual, suma);
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

    public void Multiplicar(Matriz A, Matriz B) {

        int[][] a = new int[A.getFilas()][A.getColumnas()];
        int[][] b = new int[B.getFilas()][B.getColumnas()];

        for (int i = 0; i < A.getFilas(); i++) {
            for (int j = 0; j < A.getColumnas(); j++) {
                a[i][j] = 0;
            }
        }

        for (int i = 0; i < B.getFilas(); i++) {
            for (int j = 0; j < B.getColumnas(); j++) {
                b[i][j] = 0;
            }
        }

        for (NodoColumna i = A.getCabeza(); i != null; i = i.getSiguienteElemento()) {
            for (NodoFila j = i.getElementoAbajo(); j != null; j = j.getSiguienteElemento()) {
                a[j.getFila() - 1][i.getColumna() - 1] = j.getValor();
            }
        }
        for (NodoColumna i = B.getCabeza(); i != null; i = i.getSiguienteElemento()) {
            for (NodoFila j = i.getElementoAbajo(); j != null; j = j.getSiguienteElemento()) {
                b[j.getFila() - 1][i.getColumna() - 1] = j.getValor();
            }
        }

        for (int i = 0; i < A.getFilas(); i++) {
            for (int j = 0; j < B.getColumnas(); j++) {
                int suma = 0;
                for (int k = 0; k < A.getColumnas(); k++) {
                    // aquí se multiplica la matriz
                    suma += a[i][k] * b[k][j];
                }
                resultado.insertar(i + 1, j + 1, suma);
            }
        }

    }
}
