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
public class Borwein extends Metodos {

    @Override
    double calcular_pi() {

        int n = 100;

        double a = 0.3431457505;
        double y = 0.4142135624;

        for (int i = 0; i < n; i++) {
            y = (1 - Math.pow(1 - Math.pow(y, 4), 0.25)) / (1 + Math.pow(1 - Math.pow(y, 4), 0.25));
            a = (a * Math.pow(y + 1, 4)) - (Math.pow(2, (2 * i) + 3) * y * (1 + y + (y * y)));
        }

        double pi = 1 / a;

        return pi;
    }

}
