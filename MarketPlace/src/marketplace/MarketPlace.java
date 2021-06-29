/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketplace;

import conexionesBD.Conexion;
import interfaz.VentanaPrincipal;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Jeferson Jimenez
 */
public class MarketPlace {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConection();
        
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }

}
