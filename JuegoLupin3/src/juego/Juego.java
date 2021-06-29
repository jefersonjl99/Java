/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import interfaz.Ventana;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Jimenez
 */
public class Juego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "En el juego actualmente se implementan 4 patrones que se veran comentados en las clases: \nEstadoDelJuego\nObjetoJuego\nObjetoMovible\nNOTA:"
                + "POR CUESTIONES DE TIEMPO Y COMPLEJIDAD EN LA IMPLEMENTACION DEL MOVIMIENTO\nDE CADA ENTE NO HE PODIDO IMPLEMENTAR MAS ENTES DENTRO DEL JUEGO, PERO EN LA CARPETA\n<RECURSOS>"
                + "SE PUEDE APRECIAR EL AVANCE DE CADA UNO DE ELLOS Y DE MÁS QUE SE IMPLEMENTAN\nEN ASPECTOS VISUALES PERO QUE LLEVAN MUCHO TIEMPO HACERLOS..."
                + "\nRecursos Como el Icono, la Portada y cada uno de los Sprites para los entes a implementar\n\nPARA CONTINUAR PRESIONE OK");
        JOptionPane.showMessageDialog(null, "Recuerde los controles: w,a,s,d\nshift -> correr\ne->Comer\nesc para salir");
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        ventana.iniciarHilo();
    }
;

}
