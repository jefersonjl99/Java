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
public class Agregar extends Archivo {

    @Override
    void accion(ArrayList<ArrayList<String>> usuarios, ArrayList<String> usuario, int n) {

        usuarios.add(usuario);

    }

}
