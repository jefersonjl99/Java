/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author jefer
 */
public class Lotes {

    public static void main(String[] args) {
        HashMap lotes = new HashMap();
        Dimensiones dimensiones = new Dimensiones();
        String s;
        int respuesta, area;
        do {
            s = JOptionPane.showInputDialog("Ingrese el codigo del lote: ");
            dimensiones.ancho = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ancho del lote: "));
            dimensiones.largo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el largo del lote: "));
            area = dimensiones.ancho * dimensiones.largo;
            lotes.put(s, area);
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Si desea continuar ingresando datos digite 1: "));
        } while (respuesta == 1);

        String[] a = new String[lotes.size()];
        int[] b = new int[lotes.size()];
        String tmp;
        int temp;

        Set conjunto = lotes.keySet();
        Iterator it = conjunto.iterator();

        int i = 0;
        while (it.hasNext()) {

            a[i] = (String) it.next();
            b[i] = Integer.parseInt(lotes.get(a[i]).toString());
            i++;
        }


        for (i = 0; i < lotes.size(); i++) {
            for (int j = i+1; j < lotes.size(); j++) {
                if (b[i] < b[j]) {
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }

        for (i = 0; i < a.length; i++) {
            System.out.println("Codigo: "+a[i]+" Area: "+lotes.get(a[i]));
        }

    }

}
