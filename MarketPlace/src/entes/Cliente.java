/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes;

/**
 *
 * @author Jeferson Jimenez
 */
public class Cliente extends Entes {

    private String nombre, fecha_nacimiento, telefono, direccion;
    private int edad;
    

    public Cliente(int ID) {
        super(ID);
    }

    @Override
    public void addEnte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarEnte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
