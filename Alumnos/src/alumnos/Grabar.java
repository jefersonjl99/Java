/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jefer
 */
public class Grabar extends Archivo {

    @Override
    void accion(ArrayList<ArrayList<String>> estudiantes, ArrayList<String> estudiante, int n) {

        try {

            /////
            FileWriter fw;
            String registro;

            fw = new FileWriter("ejemplo.txt", false);

            ////
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < estudiantes.size(); i++) {
                registro = "";
                for (int j = 0; j < n; j++) {
                    registro += estudiantes.get(i).get(j) + ",";

                }
                registro = registro.substring(0, registro.length() - 1);
                bw.write(registro);
                bw.newLine();
            }

            bw.close();
        } catch (IOException error) {
            System.out.println(error.toString());
        }
    }

}
