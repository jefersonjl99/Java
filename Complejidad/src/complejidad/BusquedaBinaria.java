/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complejidad;

/**
 *
 * @author jefer
 */
public class BusquedaBinaria {

    int a[];
    int t, i, d, operaciones, numero;

    boolean busqueda(int a[], int izq, int der, int x) {
        operaciones += 1;

        if (izq > der) {
            return false;
        } else {

            operaciones += 5;
            int m = (int) ((izq + der) / 2);
            if (x == a[m]) {
                return true;
            } else {
                operaciones += 2;
                if (x < a[m]) {
                    return busqueda(a, izq, m - 1, x);
                } else {
                    return busqueda(a, m + 1, der, x);
                }
            }
        }
    }

    int inicializarVariables(int n) {
        a = new int[n];
        d = n - 1;
        i = 0;
        operaciones = 0;
        numero = (int) (Math.random() * n);

        for (int h = 0; h < n; h++) {//Llenar Matriz
            a[h] = (int) (Math.random() * (n + 1));
        }
        for (int i = 0; i < n - 1; i++) {//4(n-1)+2
            for (int j = i + 1; j < n; j++) {//12(n*n - ((n-1)n)/2 - n)(n-1)
                if (a[i] > a[j]) {//
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        
        numero=a[numero];
        busqueda(a, i, d, numero);
        return operaciones;
    }
}
