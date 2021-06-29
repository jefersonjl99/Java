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
public class Catalogo extends Formato {

    private final int ID;
    private String nombre;

    public Catalogo(int ID, String nombre_formato, int id) {
        super(ID, nombre_formato);
        this.ID = id;
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
