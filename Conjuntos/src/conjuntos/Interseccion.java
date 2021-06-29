/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

/**
 *
 * @author jefer
 */
public class Interseccion implements Operaciones {

    @Override
    public int calcular(int[] a, int[] b, int[] r, int n_a, int n_b) {
        int i, j, k = 0;
        for (i = 0; i < n_a; i++) {
            for (j = 0; j < n_b; j++) {
                if (a[i] == b[j]) {
                    r[k] = a[i];
                    k++;
                }
            }
        }
        return k;
    }

}
