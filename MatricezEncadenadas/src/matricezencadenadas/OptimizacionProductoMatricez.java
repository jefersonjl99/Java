/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricezencadenadas;

import java.util.ArrayList;

/**
 *
 * @author Jeferson Jimenez
 */
public class OptimizacionProductoMatricez {

    private ArrayList<Integer>[][] matriz_numeros;
    private ArrayList<String>[][] matriz_cadenas;
    private ArrayList<String>[][] matriz_min_cad;

    public OptimizacionProductoMatricez(int dimMatriz[]) {
//        for (int i = 0; i < dimMatriz.length; i++) {
//            System.out.print(dimMatriz[i] + "\t");
//        }
//        System.out.println("\n");
        optimizarProducto(dimMatriz);
    }

    public void optimizarProducto(int dimMatriz[]) {
        int n = dimMatriz.length;
        int[][] matriz_min = new int[n][n];
        matriz_numeros = new ArrayList[n][n];
        matriz_cadenas = new ArrayList[n][n];
        matriz_min_cad = new ArrayList[n][n];
        String infin, min;
        char c = 'A';
        char[] matrices = new char[n - 1];
        for (int i = 0; i < n - 1; i++) {
            matrices[i] = c;
            c++;
        }
//        System.out.println(Arrays.toString(matrices) + "\n");
        for (int i = 0; i < n; i++) {
            matriz_min[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz_numeros[i][j] = new ArrayList<>();
                matriz_cadenas[i][j] = new ArrayList<>();
                matriz_min_cad[i][j] = new ArrayList<>();
                if (i == 0 || i == j || i > j) {
                    matriz_numeros[i][j].add(0);
                    matriz_cadenas[i][j].add("");
                    matriz_min_cad[i][j].add("");
                }
            }
        }
        for (int d = 2; d < n; d++) {
            for (int i = 1; i < n - 1 - d + 2; i++) {
                int j = i + d - 1;
                matriz_min[i][j] = Integer.MAX_VALUE; // +infinito
                String cadena = "";
                min = "";
                for (int k = i; k < j; k++) {

                    if (matriz_min[i][j] == 2147483647) {
                        infin = "∞";
                    } else {
                        infin = Integer.toString(matriz_min[i][j]);
                    }

                    int q = matriz_min[i][k] + matriz_min[k + 1][j] + dimMatriz[i - 1] * dimMatriz[k] * dimMatriz[j];

                    if (q < matriz_min[i][j]) {

                        matriz_min[i][j] = q;

                        if (matriz_min[i][k] == 0 && matriz_min[k + 1][j] == 0) {

                            cadena = "(" + matrices[i - 1] + matrices[j - 1] + ")";
                            min = "min(" + infin + ", 0 + 0 + " + dimMatriz[i - 1] + "*" + dimMatriz[k] + "*" + dimMatriz[j] + ")";

                        } else if (matriz_min[i][k] == 0 && matriz_min[k + 1][j] != 0) {

                            cadena = "[" + matrices[i - 1] + matriz_cadenas[i + 1][j].get(matriz_cadenas[i + 1][j].size() - 1) + "]";
                            min = "min(" + infin + ", 0 + " + matriz_min[i + 1][j] + " " + matriz_cadenas[i + 1][j].get(matriz_cadenas[i + 1][j].size() - 1) + " + " + dimMatriz[i - 1] + "*" + dimMatriz[k] + "*" + dimMatriz[j] + ")";

                        } else if (matriz_min[i][k] != 0 && matriz_min[k + 1][j] == 0) {

                            cadena = "[" + matriz_cadenas[i][j - 1].get(matriz_cadenas[i][j - 1].size() - 1) + matrices[j - 1] + "]";
                            min = "min(" + infin + ", " + matriz_min[i][j - 1] + matriz_cadenas[i][j - 1].get(matriz_cadenas[i][j - 1].size() - 1) + " + 0 + " + dimMatriz[i - 1] + "*" + dimMatriz[k] + "*" + dimMatriz[j] + ")";

                        } else if (matriz_min[i][k] != 0 && matriz_min[k + 1][j] != 0) {

                            cadena = "[" + matriz_cadenas[i][i + 1].get(matriz_cadenas[i][i + 1].size() - 1) + matriz_cadenas[i + 2][j].get(matriz_cadenas[i + 2][j].size() - 1) + "]";
                            min = "min(" + infin + ", " + matriz_min[i][i + 1] + matriz_cadenas[i][i + 1].get(matriz_cadenas[i][i + 1].size() - 1) + " + " + matriz_min[i + 2][j] + matriz_cadenas[i + 2][j].get(matriz_cadenas[i + 2][j].size() - 1) + " + " + dimMatriz[i - 1] + "*" + dimMatriz[k] + "*" + dimMatriz[j] + ")";

                        }

                    } else {
                        if (matriz_min[i][k] == 0 && matriz_min[k + 1][j] == 0) {

                            cadena = matriz_cadenas[i][j].get(matriz_cadenas[i][j].size() - 1);
                            min = "min(" + infin + ", 0 + 0 + " + dimMatriz[i - 1] + "*" + dimMatriz[k] + "*" + dimMatriz[j] + ")";

                        } else if (matriz_min[i][k] == 0 && matriz_min[k + 1][j] != 0) {

                            cadena = matriz_cadenas[i][j].get(matriz_cadenas[i][j].size() - 1);
                            min = "min(" + infin + ", 0 + " + matriz_min[i + 1][j] + " " + matriz_cadenas[i + 1][j].get(matriz_cadenas[i + 1][j].size() - 1) + " + " + dimMatriz[i - 1] + "*" + dimMatriz[k] + "*" + dimMatriz[j] + ")";

                        } else if (matriz_min[i][k] != 0 && matriz_min[k + 1][j] == 0) {

                            cadena = matriz_cadenas[i][j].get(matriz_cadenas[i][j].size() - 1);
                            min = "min(" + infin + ", " + matriz_min[i][j - 1] + matriz_cadenas[i][j - 1].get(matriz_cadenas[i][j - 1].size() - 1) + " + 0 + " + dimMatriz[i - 1] + "*" + dimMatriz[k] + "*" + dimMatriz[j] + ")";

                        } else if (matriz_min[i][k] != 0 && matriz_min[k + 1][j] != 0) {

                            cadena = matriz_cadenas[i][j].get(matriz_cadenas[i][j].size() - 1);
                            min = "min(" + infin + ", " + matriz_min[i][k] + matriz_cadenas[i][k].get(matriz_cadenas[i][k].size() - 1) + " + " + matriz_min[j + k - (j - 1)][j] + matriz_cadenas[j + k - (j - 1)][j].get(matriz_cadenas[j + k - (j - 1)][j].size() - 1) + " + " + dimMatriz[i - 1] + "*" + dimMatriz[k] + "*" + dimMatriz[j] + ")";

                        }

                    }

                    matriz_cadenas[i][j].add(cadena);
                    matriz_numeros[i][j].add(matriz_min[i][j]);
                    matriz_min_cad[i][j].add(min);
                }
            }

        }
//        for (int i = 0; i < matriz_min.length; i++) {
//            for (int j = 0; j < matriz_min.length; j++) {
//                System.out.print(matriz_min[i][j] + "\t");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
//        System.out.println(matriz_min[1][n - 1] + "\n");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int contadorK = 0;
//                for (int k = 0; k < matriz_numeros[i][j].size(); k++) {
//                    System.out.print(matriz_numeros[i][j].get(k) + "\t");
//                    contadorK++;
//                }
//                for (int k = 0; k < 3 - contadorK; k++) {
//                    System.out.print("\t");
//                }
//            }
//            System.out.println("");
//        }
//        System.out.println("\n\n");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int contadorK = 0;
//                for (int k = 0; k < matriz_cadenas[i][j].size(); k++) {
//                    System.out.print(matriz_cadenas[i][j].get(k) + "\t");
//                    contadorK++;
//                }
//                for (int k = 0; k < 5 - contadorK; k++) {
//                    System.out.print("\t");
//                }
//            }
//            System.out.println("");
//        }
//        System.out.println("\n\n");
//        return matriz_min[1][n - 1];
    }

    public ArrayList<Integer>[][] getMatriz_numeros() {
        return matriz_numeros;
    }

    public void setMatriz_numeros(ArrayList<Integer>[][] matriz_numeros) {
        this.matriz_numeros = matriz_numeros;
    }

    public ArrayList<String>[][] getMatriz_cadenas() {
        return matriz_cadenas;
    }

    public void setMatriz_cadenas(ArrayList<String>[][] matriz_cadenas) {
        this.matriz_cadenas = matriz_cadenas;
    }

    public ArrayList<String>[][] getMatriz_min_cad() {
        return matriz_min_cad;
    }

    public void setMatriz_min_cad(ArrayList<String>[][] matriz_min_cad) {
        this.matriz_min_cad = matriz_min_cad;
    }

}
