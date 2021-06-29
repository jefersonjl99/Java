/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes;

import servicios.Servicio;

/**
 *
 * @author Jeferson Jimenez
 */
public class Administrador extends Entes {

    private int usuarioFk, proveedorFk, servicioFk, clienteFk;

    public Administrador(int ID, Usuario usuarioFk, Proveedor proveedorFk, Servicio servicioFk, Cliente clienteFk) {
        super(ID);
        this.usuarioFk = usuarioFk.getID();
        this.proveedorFk = proveedorFk.getID();
        this.servicioFk = servicioFk.getID();
        this.clienteFk = clienteFk.getID();
    }

    public Administrador(int ID) {
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
