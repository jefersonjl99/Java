/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import static interfaz.Ventana.ALTO;
import static interfaz.Ventana.ANCHO;

/**
 *
 * @author Jeferson Jimenez
 */
public class Posicion {

    private double x, y;

    public Posicion(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Posicion() {
        x=0;
        y=0;
    }
    public void actualizar() {
        x=getX();
        y=getY();
    }
    

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if (this.x + x >= 0 && this.x + x < (ANCHO*2)-(45*2)) {
            this.x = x;
        }
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if (this.y + y >= 0 && this.y + y <= (ALTO*2)-(49*2)) {
            this.y = y;
        }
    }
    
    public Posicion getPosicion (){
        return Posicion.this;
    }

}
