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
public class Policia extends ObjetoMovible {

    public Policia(Posicion posicion, Posicion velocidad, BufferedImage textura) {
        super(posicion, velocidad, textura);
    }

    
    @Override
    public void actualizar() {
    }
    
    @Override
    public void cambiarRecurso(boolean corriendo, int numGrafico) {
    }


    @Override
    public void dibujar(Graphics g) {
    }
    
}
