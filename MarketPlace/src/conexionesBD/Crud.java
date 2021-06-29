/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionesBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author empc2
 */
public class Crud {

    Conexion cn = new Conexion();
    Connection con;
    DefaultTableModel model;
    Statement st;
    ResultSet rs;
    String resultado[];
    
    public int buscar(String correo,String contraseña) {
        String sql = "SELECT * FROM registros WHERE correo='"+correo+"' AND contraseña='"+contraseña+"';";
        int r = 0;
       
        con = cn.getConection();

            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);
                    if(rs.next()) {
                        JOptionPane.showMessageDialog(null, "Muy bien se encuentra registrado");
                    
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "el usuario no se encuentra registrado");
                        r = 1;
                    }
            } catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }

            
            
        return r;
    }
    public void registrar(String nombre,String correo,String contraseña) {
        String sql = "SELECT * FROM registros WHERE correo='"+correo+"';";
       
        con = cn.getConection();

            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);
                    if(rs.next()) {
                        JOptionPane.showMessageDialog(null, "El correo utilizado ya se encuentra registrado por favor intente de nuevo");
                    
                    }
                    else{
                         st.executeUpdate("INSERT INTO registros(Nombre,contraseña,correo) VALUES('"+nombre+"','"+contraseña+"','"+correo+"');");
                    }
            } catch (SQLException ex) {
                System.out.println("Error: "+ex);
            }

            
            

    }
    
    
}
