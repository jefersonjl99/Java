/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author jefer
 */
public class Lista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int respuesta,numero=0;
        String s="";

        ArrayList <Integer> numeros = new ArrayList <Integer>();

        do {
            numeros.add(Integer.parseInt(JOptionPane.showInputDialog("Digite el elemento a añadir en el arreglo:")));
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Si desea seguir ingresando datos digite 1:"));
            
        } while (respuesta == 1);

        Collections.sort(numeros);
        
        for (int i =0; i<numeros.size(); i ++) {
            numero+=numeros.get(i);
            if (i < numeros.size() - 1 && numeros.size() > 1) {
                s+=(" "+numeros.get(i)+",");
            } else {
                s+=(" "+numeros.get(i));
            }
        }
        
        
        JOptionPane.showMessageDialog(null, "El Arreglo es: "+s+" y su suma:"+numero);
        
        JOptionPane.showMessageDialog(null, "Hasta la proxima...");

    }
}
