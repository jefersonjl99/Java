/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import aerolinea.Reserva;
import aerolinea.vuelo.Vuelo;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Jimenez
 */
public class Pasajero {

    private String nombre;
    private String identificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public ArrayList<Vuelo> mostrar_vuelos() {
        return null;
    }

    public void generar_reserva(Reserva reserva) {
        
    }

}
