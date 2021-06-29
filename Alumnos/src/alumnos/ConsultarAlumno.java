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
public class ConsultarAlumno extends Archivo {

    JFnotas ventana2;

    @Override
    void accion(ArrayList<ArrayList<String>> estudiantes, ArrayList<String> estudiante, int n) {

        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).get(0).equals(estudiante.get(0))) {
                estudiante=estudiantes.get(i);
                ventana2 = new JFnotas(estudiantes, estudiante, n, 0);
                ventana2.setVisible(true);
            }
        }

    }

}
