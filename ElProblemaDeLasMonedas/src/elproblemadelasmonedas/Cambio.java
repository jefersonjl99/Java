/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elproblemadelasmonedas;

import java.util.ArrayList;

/**
 *
 * @author jefer
 */
public class Cambio {

    int[][] matrizCambio;
    int[] vectorMonedas;
    int cantidad;
    ArrayList<int[]> vectorSeleccion;

    Cambio(int cantidad, int[] monedas) {
        this.cantidad = cantidad;
        this.vectorMonedas = monedas;
        matrizCambio = calcularMonedas(cantidad, monedas);
        vectorSeleccion = seleccionarMonedas(cantidad, monedas, matrizCambio);
    }

    public ArrayList<int[]> getVectorSeleccion() {
        return this.vectorSeleccion;
    }

    public int[][] getMatrizCambio() {
        return matrizCambio;
    }

    private int[][] calcularMonedas(int cantidad, int[] monedas) {

        matrizCambio = new int[monedas.length + 1][cantidad + 1];

        for (int i = 0; i < monedas.length; i++) {
            matrizCambio[i][0] = 0;
        }

        for (int j = 1; j <= cantidad; j++) {
            matrizCambio[0][j] = 999999;
        }

        for (int i = 1; i <= monedas.length; i++) {
            for (int j = 1; j <= cantidad; j++) {
                if (j < monedas[i - 1]) {

                    matrizCambio[i][j] = matrizCambio[i - 1][j];
                } else {

                    int minimo = 0;

                    minimo = Math.min(matrizCambio[i - 1][j], matrizCambio[i][j - monedas[i - 1]] + 1);
                    matrizCambio[i][j] = minimo;

                }
            }
        }

        return matrizCambio;
    }

    private ArrayList<int[]> seleccionarMonedas(int c, int[] monedas, int[][] tabla) {
        ArrayList<int[]> seleccionar = new ArrayList<>();
        int i, j;
        int[] seleccion;

        for (i = 1; i <= monedas.length; i++) {

            for (j = 1; j <= c; j++) {
                int h = j;
                int k = i;
                seleccion = new int[monedas.length];
                while (h > 0) {
                    if (k > 1 && tabla[k][h] == tabla[k - 1][h]) {
                        k--;
                    } else {
                        seleccion[k - 1]++;
                        h = h - monedas[k - 1];
                    }
                }
                seleccionar.add(seleccion);
            }
        }
        /*i = monedas.length;
        j = c;
        while (j > 0) {
            if (i > 1 && tabla[i][j] == tabla[i - 1][j]) {
                i--;
            } else {
                seleccion[i - 1]++;
                j = j - monedas[i - 1];
            }
        }*/

        return seleccionar;
    }

}
