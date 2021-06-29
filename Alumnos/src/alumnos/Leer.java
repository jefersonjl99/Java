/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jefer
 */
public class Leer extends Archivo {

    @Override
    void accion(ArrayList<ArrayList<String>> estudiantes,ArrayList<String> estudiante, int n){
        estudiantes.clear();

        try {
            
            String[] datos;
            String nombre = "ejemplo.txt";
            FileReader fr = new FileReader(nombre);
            BufferedReader br = new BufferedReader(fr);
            String registro;
            registro = br.readLine();
            while (registro != null) {
                estudiante = new ArrayList<>();
                datos = registro.split(",");
                for (int i = 0; i < n; i++) {
                    estudiante.add(datos[i]);
                }

                estudiantes.add(estudiante);

                registro = br.readLine();

            }
            br.close();
        } catch (IOException error) {
            System.out.println(error.toString());
        }
    }
    
}
