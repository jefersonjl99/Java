/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

/**
 *
 * @author Jeferson Jimenez
 */
public class Servicio extends Catalogo{
    
    private final int ID;
    private String nombre;

    public Servicio(int ID, String nombre_formato, int id_catalogo, int id_servicio) {
        super(ID, nombre_formato, id_catalogo);
        this.ID=id_servicio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
