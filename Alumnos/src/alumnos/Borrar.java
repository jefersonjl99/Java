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
public class Borrar extends Archivo {
    
    @Override
    void accion(ArrayList<ArrayList<String>> estudiantes, ArrayList<String> estudiante, int n) {
        
        estudiantes.remove(n);
        
    }
    
}
