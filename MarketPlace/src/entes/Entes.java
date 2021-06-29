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
public abstract class Entes {
    private int ID;

    public Entes(int ID) {
        this.ID = ID;
    }
    
    public abstract void addEnte();
    
    public abstract void consultarEnte();

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
