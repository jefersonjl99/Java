/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notas;

/**
 *
 * @author jefer
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *
 * 1) no escribir nada en la consola.
 *
 * 2) hacer tres botones boton grabar, lee los datos, desde la interfase, y los
 * graba en el archivo boton leer, lee los datos desde el archivo y los muestra
 * en un campo JTextarea incluyendo el promedio de la nota
 *
 *
 *
 * 3) cambiar cualquier nota. Para cambiar cualquier nota, lea todo el archivo y
 * almacenelo en un arreglo en la memoria luego cambie la nota que el usuario
 * escoga y luego grabe los datos que estan el el arreglo.
 *
 *
 */
public class Archivo {

    File archivo = new File("ejemplo.txt");

    void Ingresar(ArrayList<ArrayList<String>> l) {
        try {

            /////
            FileWriter fw;
            String registro = "";

            fw = new FileWriter("ejemplo.txt",false);

            ////
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < l.size(); i++) {
                registro="";
                for (int j = 0; j < 6; j++) {
                    registro += l.get(i).get(j) + ",";
                    
                }
                registro=registro.substring(0,registro.length()-1);
                bw.write(registro);
                bw.newLine();
            }

            bw.close();
        } catch (IOException error) {
            System.out.println(error.toString());
        }
    }

    void leer(ArrayList<ArrayList<String>> l) {

        l.clear();

        try {
            
            String[] datos;
            String nombre = "ejemplo.txt";
            FileReader fr = new FileReader(nombre);
            BufferedReader br = new BufferedReader(fr);
            String registro;
            registro = br.readLine();
            while (registro != null) {
                ArrayList<String> estudiante = new ArrayList<>();
                datos = registro.split(",");
                for (int i = 0; i < 6; i++) {
                    estudiante.add(datos[i]);
                }

                l.add(estudiante);

                registro = br.readLine();

            }
            br.close();
        } catch (IOException error) {
            System.out.println(error.toString());
        }
    }
}
