/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosJuego;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import math.Posicion;

/**
 *
 * @author Jeferson Jimenez
 */
/*
En esta clase hacemos uso del patron Prototype donde damos los parametros iniciales de los cuales va a depender o necesitara cada objeto dentro del mapa para su uso
e implementacion, de esta se pueden derivar varios tipos de clases con diferente tipos de comportamiento y de parametros dependiendo de si es o no un objeto estatico,
por ejemplo si es o no solido, etc.
*/
public abstract class ObjetoJuego {

    protected BufferedImage textura;
    protected Posicion posicion;

    public ObjetoJuego(Posicion posicion, BufferedImage textura) {
        this.posicion = posicion;
        this.textura = textura;
    }

    public ObjetoJuego() {
    }

    public abstract void actualizar();

    public abstract void dibujar(Graphics g);

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

}
