/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gauss;

/**
 *
 * @author jefer
 */
public class Determinante {

    public void calculoDeterminante(double variables[][], int n, int sig_oe[]) {
        double determinante = 1;
        int oe = 1, hp = 0, signo = 1;

        for (int i = 0; i < n - 1; i++) {

            oe += 6;
            if (variables[i][i] == 0) {

                oe += 2;
                for (int j = 0; j < n; j++) {

                    oe = oe + 17;

                    double temp;
                    temp = variables[i][j];
                    variables[i][j] = variables[i + 1][j];
                    variables[i + 1][j] = temp;
                    signo *= -1;
                }// j

                i--;
                oe++;
                
            } else {
            
                oe += 3;
                for (int k = i + 1; k < n; k++) {
                
                    oe += 5;
                    for (int j = i + 1; j < n; j++) {
                    
                        hp+=16;
                        oe = oe + 16;
                        
                        variables[k][j] = variables[k][j] - (variables[k][i] * variables[i][j]) / variables[i][i];
                    }// j
                } // k
            }
        }
        
        System.out.println("hp:"+hp);
        System.out.println("formula: "+(16*(3*n*n)+n+((n*n*n)/3)-(5*n/6)-(n*n/2)));
        oe += 4;

        sig_oe[0] = oe;
        sig_oe[1] = signo;
    }
}
