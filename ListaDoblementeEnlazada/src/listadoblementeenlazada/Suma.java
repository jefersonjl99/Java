/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadoblementeenlazada;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jeferson Jimenez
 */
public class Suma {

    private Lista lista_num1;
    private Lista lista_num2;
    private Lista lista_resultado;

    private Nodo nodoActual_1;
    private Nodo nodoActual_2;

    public void sumar(JTextField field_ingreso, JTextField field_ingreso1, JLabel label_salida) {
        lista_num1 = new Lista();
        lista_num2 = new Lista();
        lista_resultado = new Lista();
        String num_1 = field_ingreso.getText(), num_2 = field_ingreso1.getText();
        char[] entrada;
        double modulo_num1 = (Math.ceil((double) num_1.length() / 4)), modulo_num2 = (Math.ceil((double) num_2.length() / 4));
        entrada = num_1.toCharArray();
        int h = 0, tamañoArray = ((int) modulo_num1 * 4);
        num_1 = "";
        for (int i = 0; i < tamañoArray; i++) {
            if (i < (tamañoArray) - entrada.length) {
                num_1 += 0;
            } else {
                num_1 += Integer.parseInt(String.valueOf(entrada[h]));
                h++;
            }
        }
        System.out.println("num1: " + num_1);
        for (int i = 0; i < tamañoArray; i += 4) {
            lista_num1.insertarFinal((num_1.substring(i, i + 4)));
        }
        lista_num1.print();
        entrada = num_2.toCharArray();
        tamañoArray = ((int) modulo_num2 * 4);
        num_2 = "";
        h = 0;
        for (int i = 0; i < tamañoArray; i++) {
            if (i < (tamañoArray) - entrada.length) {
                num_2 += 0;
            } else {
                num_2 += Integer.parseInt(String.valueOf(entrada[h]));
                h++;
            }
        }
        System.out.println("num2: " + num_2);
        for (int i = 0; i < tamañoArray; i += 4) {
            lista_num2.insertarFinal((num_2.substring(i, i + 4)));
        }
        lista_num2.print();

        if (modulo_num1 > modulo_num2) {
            int anterior = 0, suma = 0;
            for (int i = 0; i < modulo_num1; i++) {
                if (i < modulo_num2) {
                    nodoActual_1 = lista_num1.obtenerNodoHaciaAtras(i);
                    nodoActual_2 = lista_num2.obtenerNodoHaciaAtras(i);
                    suma = Integer.parseInt(nodoActual_1.getValor()) + Integer.parseInt(nodoActual_2.getValor()) + anterior;
                    if (suma >= 10000) {
                        suma -= 10000;
                        anterior = 1;
                    } else {
                        anterior = 0;
                    }
                    lista_resultado.insertarPrimero(String.format("%04d", suma));

                } else {
                    nodoActual_1 = lista_num1.obtenerNodoHaciaAtras(i);
                    if (anterior == 1) {
                        lista_resultado.insertarPrimero(String.format("%04d", Integer.parseInt(nodoActual_1.getValor()) + anterior));
                        anterior = 0;
                    } else {
                        lista_resultado.insertarPrimero(String.format("%04d", Integer.parseInt(nodoActual_1.getValor())));
                    }
                }
            }

        } else {
            int anterior = 0, suma = 0;
            for (int i = 0; i < modulo_num2; i++) {
                if (i < modulo_num1) {
                    nodoActual_1 = lista_num1.obtenerNodoHaciaAtras(i);
                    nodoActual_2 = lista_num2.obtenerNodoHaciaAtras(i);
                    suma = Integer.parseInt(nodoActual_1.getValor()) + Integer.parseInt(nodoActual_2.getValor()) + anterior;
                    if (suma >= 10000) {
                        suma -= 10000;
                        anterior = 1;
                    } else {
                        anterior = 0;
                    }
                    lista_resultado.insertarPrimero(String.format("%04d", suma));
                } else {
                    nodoActual_2 = lista_num2.obtenerNodoHaciaAtras(i);
                    if (anterior == 1) {
                        lista_resultado.insertarPrimero(String.format("%04d", Integer.parseInt(nodoActual_2.getValor()) + anterior));
                        anterior = 0;
                    } else {
                        lista_resultado.insertarPrimero(String.format("%04d", Integer.parseInt(nodoActual_2.getValor())));
                    }
                }
            }
        }
        System.out.println("lista resultado:");
        lista_resultado.print();

        label_salida.setText("<html><div style='text-align: right;'>" + num_1 + "<p>+ " + num_2 + "<p><font color='white'>___________________________________________________________</font><p>" + lista_resultado.obtenerLista() + "</div></html>");

    }
}
