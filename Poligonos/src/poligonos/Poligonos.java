/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligonos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class Poligonos extends JFrame
{
    int nLados=0;
    double x,y,x0,y0,x1,y1;
    final int radio=100;


    JButton pintar = new JButton ("Pintar Poligono");
    JButton borrar = new JButton ("Borrar Poligono");
    JTextArea escribir =new JTextArea ("");
    JTextArea escribirExist =new JTextArea ("");
    JTextField leer = new JTextField ("");


    public static void main(String[] args)
    {
        Poligonos obj=new Poligonos();
        obj.setSize(500,1000);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Poligonos()
    {
        super("Poligonos");
        Container p =getContentPane();
        p.setLayout(null);



        p.add(escribir);
        p.add(leer);
        p.add(pintar);
        p.add(borrar);
        p.add(escribirExist);
        p.setBackground(Color.white);
        escribir.setText("Digite el numero de lados: ");
        escribir.setFont(new Font("Arial", Font.BOLD, 12));
        escribir.setEditable(false);
        escribir.setBounds(10, 10, 150, 20);
        escribirExist.setEditable(false);
        escribirExist.setBounds(10, 40, 260, 20);
        escribirExist.setVisible(false);
        escribirExist.setForeground(Color.red);
        leer.setBounds(160, 10, 100, 20);
        pintar.setBounds(270, 10, 200, 20);
        pintar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        borrar.setBounds(270, 40, 200, 20);
        borrar.setBackground(Color.red);
        borrar.setForeground(Color.WHITE);
        
        

        ActionListener oir = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Graphics g;
                g=getGraphics ();
                nLados=Integer.parseInt(leer.getText());
                if(nLados>=3)
                {
                    escribirExist.setVisible(false);
                    x0=(radio*Math.cos((2*Math.PI)/nLados))+250;
                    y0=(radio*Math.sin((2*Math.PI)/nLados))+250;
                    
                    for(double i=0;i<2*Math.PI;i+=(2*Math.PI)/nLados){
                        x=(radio*Math.cos(i))+250;
                        y=(radio*Math.sin(i))+250;
                        g.drawLine((int) x,(int) y,(int) x0,(int) y0);
                        x0=x;
                        y0=y;
                    }
                    g.drawLine((int) x,(int) y,(int) (radio*Math.cos(0))+250,(int) (radio*Math.sin(0))+250);
                }
                else
                {
                    escribirExist.setText("No se puede construir un poligono de "+nLados+" lados");
                    escribirExist.setVisible(true);
                }

                //g.drawPolygon(poligono);
            }
        };
        pintar.addActionListener(oir);


        ActionListener oir1 = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                p.repaint();
            }
        };
        borrar.addActionListener(oir1);

    }
}

/*    
public void paint(Graphics g) {
Graphics2D g2d = (Graphics2D)g;
Polygon polygon = new Polygon();
polygon.addPoint(x, y);
// Agregar mas puntos...
g2d.drawPolygon(polygon);
}
}*/
