/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

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
    void accion(ArrayList<ArrayList<String>> usuarios,ArrayList<String> usuario, int n){
        usuarios.clear();

        try {
            
            String[] datos;
            String nombre = "Datos.txt";
            FileReader fr = new FileReader(nombre);
            BufferedReader br = new BufferedReader(fr);
            String registro;
            registro = br.readLine();
            while (registro != null) {
                usuario = new ArrayList<>();
                datos = registro.split(",");
                for (int i = 0; i < n; i++) {
                    usuario.add(datos[i]);
                }

                usuarios.add(usuario);

                registro = br.readLine();

            }
            br.close();
        } catch (IOException error) {
            System.out.println(error.toString());
        }
    }
    
}
