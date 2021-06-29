/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relojdigital;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;


/**
 *
 * @author jefer
 */
public class RelojDigital extends JFrame {
    
    JLabel tiempo = new JLabel();

    static Timer t;

    public static void main(String[] linea) {
        RelojDigital obj = new RelojDigital();
        obj.setSize(400, 60);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
    }

    RelojDigital() {
        super("Reloj Digital");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(tiempo);
        
        ActionListener oye = new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                Calendar c = Calendar.getInstance();
                tiempo.setText("Año: "+ c.get(Calendar.YEAR)+"  Mes: "+ (c.get(Calendar.MONTH)+1)+"  Dia:"+ c.get(Calendar.DAY_OF_MONTH)+"  Hora: "+ c.get(Calendar.HOUR)+":"+ c.get(Calendar.MINUTE)+":"+ c.get(Calendar.SECOND));
            }
        };
        t = new Timer(1000, oye);
        t.start();
    }
}
