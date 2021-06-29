/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

/**
 *
 * @author jefer
 */
class Sentido {

    double ang;

    Sentido() {
        ang = -0.10472;
    }

    void cambiar(int num) {
        if (num % 2 == 0) {
            ang = 0.10472;
        } else {
            ang = -0.10472;
        }
    }

    double sent() {
        return ang;
    }
}
