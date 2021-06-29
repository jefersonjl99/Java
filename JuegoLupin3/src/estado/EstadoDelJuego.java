/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estado;

import objetosJuego.Jugador;
import graficos.Recursos;
import static interfaz.Ventana.ALTO;
import static interfaz.Ventana.ANCHO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import math.Posicion;
import objetosJuego.Policia;

/**
 *
 * @author Jeferson Jimenez
 */

/*Fabrica Abstracta
En esta clase como lo mencionaba se implementa el patron Fabrica o Factori para dar la creacion de cada uno de los entes y objetos que 
se les dara cabida en el aplicativo, para este caso solo se ha alcanzado a implementar para 2 entes que son el jugador en si y el policia, que no ha de aparecer
en el momento en la ventana pero como tal se encuentra creado
 */
 /*
A su vez hacemos uso de patron singleton para que cada uno de los entes que se generen sean UNICOS en teste caso el policia y el jugador con unicos haciendo uso 
del condicional STATIC
 */
public class EstadoDelJuego {

    private static Jugador jugador;
    private static Policia policia;
    private static final BufferedImage RECURSO_JUGADOR = Recursos.jugador_down;

    public EstadoDelJuego() {
        jugador = new Jugador(new Posicion(ANCHO / 2, ALTO / 2), new Posicion(), RECURSO_JUGADOR);
        policia = new Policia(new Posicion(ANCHO / 2, ALTO / 2), new Posicion(), RECURSO_JUGADOR);
    }
    

    public void actualizar() {
        jugador.actualizar();
        policia.actualizar();
    }

    public void dibujar(Graphics g) {
        jugador.dibujar(g);
        policia.dibujar(g);
    }

    public Posicion obtenerPosicion() {
        return jugador.getPosicion();
    }

}
