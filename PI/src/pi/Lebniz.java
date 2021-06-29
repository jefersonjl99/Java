/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

/**
 *
 * @author jefer
 */
public class Lebniz extends Metodos {

    @Override
    double calcular_pi() {

        double acumular, signo, n = 500000000;

        signo = 1;
        acumular = 1;
        for (int i = 2; i < n; i++) {
            acumular = acumular - signo / (i * 2 - 1);
            signo = -signo;
        }
        acumular = acumular * 4;
        return acumular;
    }

}
