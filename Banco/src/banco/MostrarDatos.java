/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;

/**
 *
 * @author jefer
 */
class MostrarDatos extends Archivo {
    Leer leer = new Leer();
    JFDatos ventana2;

    @Override
    void accion(ArrayList<ArrayList<String>> usuarios, ArrayList<String> usuario, int n) {
        leer.accion(usuarios, usuario, n);
        ventana2 = new JFDatos(8, 0);
        ventana2.setVisible(true);
    }
}
