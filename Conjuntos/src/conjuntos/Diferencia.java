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
public class Diferencia implements Operaciones {

    @Override
    public int calcular(int[] a, int[] b, int[] r, int n_a, int n_b) {
        char ban = 'V';
        int i, j, cont = 0;
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    ban = 'F';
                }
            }
            if (ban == 'V') {
                r[cont] = a[i];
                cont++;
            }
            ban = 'V';
        }
        return cont;
    }
}


