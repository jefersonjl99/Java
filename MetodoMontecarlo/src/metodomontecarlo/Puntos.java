/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodomontecarlo;

/**
 *
 * @author jefer
 */
public class Puntos {

    double x, y;

    Puntos generar_punto_aleatorio(double d) {

        this.x = (Math.random()*(d));
        this.y = (Math.random()*(d));

        return this;

    }

    boolean esta_dentro(double r) {
        
        return (Math.sqrt(Math.pow(this.x-(r), 2) + Math.pow(this.y-(r), 2))) <= (r);
    }
}
