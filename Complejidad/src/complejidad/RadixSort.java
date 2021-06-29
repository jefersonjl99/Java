/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complejidad;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jefer
 */
public class RadixSort extends Metodos {

    @Override
    int complejidad(int n, int tam) {

        int operaciones = 0;

        //Creacion y llenado del arreglo
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }
        ////////////

        int max = a[0];

        operaciones += 3;

        for (int i = 1; i < n; i++) {
            operaciones += 4;
            if (a[i] > max) {
                operaciones += 2;
                max = a[i];
            }
        }//

        operaciones += 4;

        int posicion = 1;

        while (max / posicion > 0) {//

            operaciones += 11;

            int[] salida = new int[n];
            int[] conteo = new int[n + 1];
            for (int i = 0; i < n; i++) {
                operaciones += 6;
                conteo[(a[i] / posicion) % 10]++;
            }
            for (int i = 1; i < n; i++) {
                operaciones += 8;
                conteo[i] = conteo[i] + conteo[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                operaciones += 17;
                salida[conteo[(a[i] / posicion) % 10] - 1] = a[i];
                conteo[(a[i] / posicion) % 10]--;
            }
            for (int i = 0; i < n; i++) {
                operaciones += 5;
                a[i] = salida[i];
            }
            if (n > 9) {
                operaciones += 2;
                posicion *= 10;
            } else {
                operaciones++;
                posicion++;
            }

        }

        //Imprime array
        if (n == tam) {
            for (int h = 0; h < n; h++) {
                System.out.print(a[h] + " ");
            }
            System.out.println("");
        }/////////////////////////

        return operaciones;

    }
}

/*int a[] = new int[n];

        for (int i = 0; i < n; i++) {//Llenar Matriz
            a[i] = n - i;
        }

        if (n == 0) {
            return 0;
        }

        int[][] np = new int[n][2];

        int[] q = new int[256];

        int i, j, k, l, f = 0;

        for (k = 0; k < 4; k++) {

            for (i = 0; i < (np.length - 1); i++) {
                np[i][1] = i + 1;
            }

            np[i][1] = -1;

            for (i = 0; i < q.length; i++) {
                q[i] = -1;
            }

            for (f = i = 0; i < n; i++) {

                j = ((255 << (k << 3)) & a[i]) >> (k << 3);

                if (q[j] == -1) {
                    l = q[j] = f;
                } else {

                    l = q[j];

                    while (np[l][1] != -1) {
                        l = np[l][1];
                    }

                    np[l][1] = f;

                    l = np[l][1];

                }

                f = np[f][1];

                np[l][0] = a[i];

                np[l][1] = -1;

            }

            for (l = q[i = j = 0]; i < 256; i++) {
                for (l = q[i]; l != -1; l = np[l][1]) {
                    a[j++] = np[l][0];
                }
            }

        }*/
