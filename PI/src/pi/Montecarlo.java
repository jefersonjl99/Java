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
public class Montecarlo extends Metodos {

    double x, y;

    @Override
    double calcular_pi() {

        int n = 50000000;

        int contadorAdentro = 0;

        for (int i = 0; i < n; i++) {

            this.x = (Math.random() * 2);
            this.y = (Math.random() * 2);

            if (this.esta_dentro(1) == true) {
                /*
                        g.setColor(Color.RED);
                        g.drawString(".", (int) ((punto.x * 100) / (radio)) + 149, (int) ((punto.y * 100) / (radio)) + 201);*/
                contadorAdentro++;
            }

        }
        double pi = (double) ((4 * (double) contadorAdentro) / ((double) n));
        return pi;
    }

    boolean esta_dentro(double r) {

        return (Math.sqrt(Math.pow(this.x - (r), 2) + Math.pow(this.y - (r), 2))) <= (r);
    }

}
