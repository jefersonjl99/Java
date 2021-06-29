/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import ubicacion.Ciudad;
import aerolinea.vuelo.Vuelo;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Jimenez
 */
public class Administrador {

    /**
     * @param args the command line arguments
     */
    private ArrayList<Ciudad> ciudades;
    private ArrayList<Vuelo> vuelos;

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public void añadir_ciudad(Ciudad ciudad) {

    }

    public void eliminar_ciudad(Ciudad ciudad) {

    }

    public void añadir_vuelo(Vuelo vuelo) {

    }

    public void eliminar_vuelo(Vuelo vuelo) {

    }

}
