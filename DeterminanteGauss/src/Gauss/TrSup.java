/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gauss;

public class TrSup {

    int m, n, x = 0;

    TrSup(int n, int m) {
        this.m = m;
        this.n = n;
    }

    public double[][] dejarTRSuperior(int m, int n, double[][] matriz) {
        int p = 0, cont;
        double piv;
        for (int i = 0; i < m; i++) {
            cont = 0;
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == 0) {
                    cont++;
                }
            }

            if (cont == n || i > n - 1) {
                for (int t = i; t < m; t++) {
                    for (int j = 0; j < n; j++) {
                        matriz[t][j] = 0;
                    }
                }

            } else {
                piv = 0;
                if (i == m - 1) {
                    System.out.println("M: " + m);
                    break;
                }
                for (int j = i + 1; j < n; j++) {

                    if (j < m) {
                        piv = matriz[j][i];
                        for (int k = i; k < n; k++) {
                            p++;
                            if (matriz[i][i] == 0) {
                                for (int l = 0; l < n; l++) {
                                    matriz[i + 1][l] = 0;
                                }
                            } else {
                                matriz[j][k] = (matriz[j][k]) - (((matriz[i][k] * piv) / matriz[i][i]));
                            }
                        }
                    }
                }

            }
        }
        return matriz;
    }

    public int calculoRango(double[][] matriz) {

        int calc, rango, rangotemp = 0;

        for (int i = 0; i < m; i++) {
            calc = 0;
            rango = 0;
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != 0) {
                    calc++;
                }
            }
            if (calc > 0) {
                rango++;
                rangotemp += rango;
            }
        }
        System.out.println("Rango: " + rangotemp);
        return rangotemp;
    }
}
