/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.util.ArrayList;

/**
 *
 * @author jefer
 */
public class MostrarDatos extends Archivo {

    Leer leer = new Leer();
    JFnotas ventana2;

    @Override
    void accion(ArrayList<ArrayList<String>> estudiantes, ArrayList<String> estudiante, int n) {
        leer.accion(estudiantes, estudiante, n);
        ventana2 = new JFnotas(estudiantes, estudiante, n, 1);
        ventana2.setVisible(true);
    }

}
