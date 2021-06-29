/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea;

import aerolinea.vuelo.Silla;
import aerolinea.vuelo.Vuelo;
import ubicacion.Ciudad;
import usuarios.Pasajero;

/**
 *
 * @author Jeferson Jimenez
 */
public class Reserva {
    private Ciudad destino;
    private Vuelo vuelo;
    private Silla silla;
    private Pasajero pasajero;

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Silla getSilla() {
        return silla;
    }

    public void setSilla(Silla silla) {
        this.silla = silla;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
    
}
