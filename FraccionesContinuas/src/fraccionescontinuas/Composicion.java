/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraccionescontinuas;

/**
 *
 * @author jefer
 */
public class Composicion {

    Fracciones fracciones = new Fracciones();

    public Composicion() {
    }

    void enviar(int numerador, int denominador) {
        fracciones.asignar(numerador, denominador);
    }
}
