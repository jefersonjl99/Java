/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complejidad;

/**
 *
 * @author ssrs_
 */
public class MergeSort {

    int[] a;
    int n;
    int operaciones;
    int w = 0;

    // clasifica desde
// la posicion 1 . Por ej. para
// a=[20,-1,5,6,7,5,4,5,6];
// la llamada es fusion(a,8);
    int llenar(int n, int tam) {
        operaciones = 0;
        a = new int[n];
        for (int i = 0; i < n; i++) {//Llenar Matriz
            a[i] = n - i;
        }
        fusion(a, n - 1);

        if (n == tam) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("");
        }
        return operaciones;
    }

    int llenarAleat(int n, int tam) {
        operaciones = 0;
        a = new int[n];
        for (int i = 0; i < n; i++) {//Llenar Matriz
            a[i] = (int) (Math.random() * (n + 1));
        }
        fusion(a, n - 1);

        if (n == tam) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("");
        }

        return operaciones;
    }

    void fusion(int[] a, int n) {
        operaciones += 2;
        if (n == 1) {
            return;
        }
        if (n == 2) {
            operaciones += 3;
            if (a[1] > a[2]) {
                operaciones += 7;
                int t = a[1];
                a[1] = a[2];
                a[2] = t;
                return;
            }
        } else {
            operaciones += 16;
            int[] u = new int[n];
            int[] v = new int[n + 1];
            int dividir = (int) (n / 2);
            for (int k = 1; k <= dividir; k++) {
                operaciones += 5;
                u[k] = a[k];
            }
            for (int j = 1, k = dividir + 1;
                    k <= n; k++, j++) {
                operaciones += 10;
                v[j] = a[k];
            }
            fusion(u, dividir);
            fusion(v, n - dividir);
            mezclar(u, dividir, v, n - dividir, a);
        }
    }

    void mezclar(int[] u, int mu, int[] v, int mv, int[] a) {
        operaciones += 9;
        int i = 1;
        int j = 1;
        u[mu + 1] = 32767;
        v[mv + 1] = 32767;
        for (int k = 1; k <= mu + mv; k++) {
            operaciones += 6;
            if (u[i] < v[j]) {
                operaciones += 5;
                a[k] = u[i];
                i++;
            } else {
                operaciones += 5;
                a[k] = v[j];
                j++;
            }
        }
    }

}
