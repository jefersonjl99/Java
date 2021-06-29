/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elproblemadelamochila;

/**
 *
 * @author jefer
 */
public class Mochila {

    int optimizarPeso(int articulos, int pesoMax, int precios[], int pesos[]) {

        if (articulos < 0) {
            return 0;
        }
        if (pesos[articulos] > pesoMax) {
            return optimizarPeso(articulos - 1, pesoMax, precios, pesos);
        } else {
            return Math.max(optimizarPeso(articulos - 1, pesoMax, precios, pesos), optimizarPeso(articulos - 1, pesoMax - pesos[articulos], precios, pesos) + precios[articulos]);
        }
    }
}
