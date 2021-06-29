/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baloto;

import java.util.Arrays;

/**
 *
 * @author jefer
 */
class Numeros {
    
    int a[] = new int[5];
    int[] aleatorios = new int[5];
    int indice;
    int superb, sb;
    int cont;
    int cont2;

    Numeros() {
        indice = 0;
        cont = 0;
        cont2 = 0;
    }

    void asignar(int n) {
        if (indice < 5) {
            a[indice] = n;
            indice++;
        } else {
            superb = n;
        }
        if (superb != 0) {
            for (int j = 0; j < 5; j++) {
                System.out.print(a[j] + "\t");
            }
            System.out.println(superb + "");
        }
    }

    boolean generar(double[] z) {
        Arrays.sort(a);
        do {
            aleatorios[0] = (int) (Math.random() * 43) + 1;
            aleatorios[1] = (int) (Math.random() * 43) + 1;
            aleatorios[2] = (int) (Math.random() * 43) + 1;
            aleatorios[3] = (int) (Math.random() * 43) + 1;
            aleatorios[4] = (int) (Math.random() * 43) + 1;
            sb = (int) (Math.random() * 16) + 1;
        } while (aleatorios[0] == aleatorios[1] || aleatorios[0] == aleatorios[2] || aleatorios[0] == aleatorios[3] || aleatorios[0] == aleatorios[4] || aleatorios[0] == sb
                || aleatorios[1] == aleatorios[2] || aleatorios[1] == aleatorios[3] || aleatorios[1] == aleatorios[4] || aleatorios[1] == sb
                || aleatorios[2] == aleatorios[3] || aleatorios[2] == aleatorios[4] || aleatorios[2] == sb
                || aleatorios[3] == aleatorios[4] || aleatorios[3] == sb
                || aleatorios[4] == sb);

        Arrays.sort(aleatorios);
        boolean r = comparar(z);
        return r == true;
    }

    boolean comparar(double[] z) {
        if (a[0] == aleatorios[0] && a[1] == aleatorios[1] && a[2] == aleatorios[2] && a[3] == aleatorios[3] && a[4] == aleatorios[4] && superb == sb) {

            cont++;
            cont2++;

            for (int j = 0; j < 5; j++) {
                System.out.println(a[j] + "->" + aleatorios[j]);
            }
            System.out.println(superb + "->" + sb);

            double siglos = cont / 5400.0;

            z[0] = cont;
            z[1] = siglos;
            z[2] = cont2;

            System.out.println("\nCoincidieron despues  de " + cont + " semanas\nJugo " + siglos + " siglos\n\nPD: Los primeros 5 numeros coincidieron: " + cont2 + " veces");

            return true;
        } else {
            if (a[0] == aleatorios[0] && a[1] == aleatorios[1] && a[2] == aleatorios[2] && a[3] == aleatorios[3] && a[4] == aleatorios[4]) {
                cont2++;
            }

            cont++;

            return false;
        }
    }
}
