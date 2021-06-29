package conjuntos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jefer
 */
public class Union implements Operaciones {

    @Override
    public int calcular(int[] a, int[] b, int[] r, int n_a, int n_b) {
        int i, j, k = 0;
        for (i = 0; i < n_a; i++) {
            r[k] = a[i];
            k++;
        }
        k = n_a;
        for (j = 0; j < n_b; j++) {
            for (i = 0; i < k && r[i] != b[j]; i++) {
            }
            if (i == k) {
                r[i] = b[j];
                k++;
            }

        }
        return k;
    }

}
