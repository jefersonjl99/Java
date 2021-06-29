/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Jeferson Jimenez
 */
public class Conexion {

    private static Connection conection;
//    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "password1234";
    private static final String URL = "jdbc:mysql://localhost:3306/marketplace";

    public Conexion() {
        conection = null;
        try {
//            Class.forName(DRIVER);
            conection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conection != null) {
                System.out.println("Conexion Establecida");
            }
        } catch (SQLException ex) {
            System.out.println("Conexion Erronea");
        }
    }

    public Connection getConection() {
        return conection;
    }

    public static void setConection(Connection conection) {
        Conexion.conection = conection;
    }

    
    public void desconectar(){
        conection=null;
        if(conection==null)
            System.out.println("Conexion terminada...");
    }

}
