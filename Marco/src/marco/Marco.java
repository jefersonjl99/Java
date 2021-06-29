/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marco;


import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jefer
 */
public class Marco extends JFrame{

    
    JButton boton= new JButton("Pintar Rectangulo");
    JButton boton1= new JButton("Pintar Linea");
    JButton boton2= new JButton("Pintar Circulo");
    JButton boton3= new JButton("Pintar Cuadrado");
    JButton boton4= new JButton("Pintar grafica");
    JButton boton5= new JButton("Limpiar Ventana");
    
    public static void main(String[] args) {
        Marco obj=new Marco();
        obj.setSize(1000,1000);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    Marco(){
        super("Explicacion.....");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(boton);
        c.add(boton1);
        c.add(boton2);
        c.add(boton3);
        c.add(boton4);
        c.add(boton5);
        boton5.setBackground(Color.black);
        boton5.setForeground(Color.white);
        boton5.setBorderPainted(true);
        boton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        
       
   
        ActionListener oir = (ActionEvent e) -> {
            Graphics g;
            g=getGraphics();
            g.drawRect(50, 100, 100, 50);
        };boton.addActionListener(oir);
        
        ActionListener oir1 = (ActionEvent e) -> {
            Graphics g;
            g=getGraphics();
            g.drawLine(250, 100, 250, 150);
        };boton1.addActionListener(oir1);
        
        ActionListener oir2;
        oir2 = (ActionEvent e) -> {
            Graphics g;
            g=getGraphics();
            g.drawOval(330, 100, 50, 50);
        };boton2.addActionListener(oir2);
        
        ActionListener oir3 = (ActionEvent e) -> {
            Graphics g;
            g=getGraphics();
            g.drawRect(460, 100, 50, 50);
        };boton3.addActionListener(oir3);
        
        ActionListener oir4 = (ActionEvent e) -> {
            Graphics g;
            g = getGraphics();
            g.drawLine(700, 100, 700, 600);
            g.drawLine(600,400,800,400);
            double x1;
            double y1;
            for (x1 = -4; x1 <= 4; x1 = x1 + 0.001) {
                if (x1 != 0) {
                    y1 = 1 / x1;
                    double xp,yp;
                    xp = 700 - x1 * 20;
                    yp = 400 - y1 * 20;
                    g.drawLine((int) xp, (int) yp,(int) xp, (int) yp);
                    g.setColor(Color.red);
                }
            }
        };boton4.addActionListener(oir4);
        
        ActionListener oir5 = (ActionEvent e) -> {
            Graphics g;
            g=getGraphics();
            g.clearRect(0, 62, 1000, 1000);
        };boton5.addActionListener(oir5);
    }
}
//tarea cuadro,circulo,linea
//leer las tres longitudes del triangulo con 3botones: pintar trianguo, borrar triangulo, escribir tipo de triangulo, calcular area triangulo, mirar si se puede formar triangulo