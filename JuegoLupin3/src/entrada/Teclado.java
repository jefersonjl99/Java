/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Jeferson Jimenez
 */
public class Teclado implements KeyListener {

    private boolean[] teclas = new boolean[256];
    public static boolean UP, DOWN, LEFT, RIGHT, CORRER, EXIT, COMER, z;

    public Teclado() {
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
        EXIT = false;
        CORRER = false;
        COMER = false;
        z = false;
        
    }

    public void actualizar() {
        UP = teclas[KeyEvent.VK_W];
        RIGHT = teclas[KeyEvent.VK_D];
        DOWN = teclas[KeyEvent.VK_S];
        LEFT = teclas[KeyEvent.VK_A];
        CORRER = teclas[KeyEvent.VK_SHIFT];
        COMER = teclas[KeyEvent.VK_E];
        EXIT = teclas[KeyEvent.VK_ESCAPE];
        z = teclas[KeyEvent.VK_Z];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Tecleo:"+e.getKeyChar());
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("solto:"+e.getKeyChar());
        teclas[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
