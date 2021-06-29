/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trianguloclicks;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jefer
 */
public class TrianguloClicks extends JFrame implements MouseListener
{
    DecimalFormat formato1 = new DecimalFormat("#0.00");

    JLabel r_area = new JLabel ("");
    JLabel ladoAB = new JLabel ("");
    JLabel ladoBC = new JLabel ("");
    JLabel ladoCA = new JLabel ("");

    Point matriz[] = new Point[3];
    int j=0;
    Polygon triangulo=new Polygon ();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here

        TrianguloClicks obj=new TrianguloClicks();
        obj.setSize(600,640);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
    }

    public TrianguloClicks()
    {
        super("Triangulo");
        Container t =getContentPane();
        t.setLayout(null);

        t.setBackground(Color.LIGHT_GRAY);
        t.add(r_area);
        t.add(ladoAB);
        t.add(ladoBC);
        t.add(ladoCA);

        r_area.setBounds(10, 500, 200, 20);
        ladoAB.setBounds(10, 520, 200, 20);
        ladoBC.setBounds(10, 540, 200, 20);
        ladoCA.setBounds(10, 560, 200, 20);


        addMouseListener(this);
    }
    public void mouseClicked(MouseEvent e1)
    {

    }
    public void mouseEntered(MouseEvent e1)
    {

    }
    public void mouseExited(MouseEvent e1)
    {

    }
    public void mousePressed(MouseEvent e1)
    {
        Graphics g=getGraphics();
        if(j==3)
        {
            j=0;
            g.clearRect(0, 0, 1000, 1000);
            triangulo.reset();
        }


        Point p = e1.getPoint();
        matriz[j]= p;
        if(j==0)
        {
            g.drawString("P(A): ("+p.x+","+p.y+")", p.x,p.y-20);
        }
        else if(j==1)
        {
            g.drawString("P(B): ("+p.x+","+p.y+")", p.x,p.y-20);
        }
        else if(j==2)
        {
            g.drawString("P(C): ("+p.x+","+p.y+")", p.x,p.y-20);
        }
        triangulo.addPoint(p.x, p.y);
        j++;
        if(j==3)
        {
            
            g.setColor(Color.MAGENTA);
            g.drawPolygon(triangulo);
            g.setColor(Color.red);
            double AB=Math.sqrt(Math.pow(matriz[1].x-matriz[0].x, 2)+Math.pow(matriz[1].y-matriz[0].y, 2));
            double BC=Math.sqrt(Math.pow(matriz[2].x-matriz[1].x, 2)+Math.pow(matriz[2].y-matriz[1].y, 2));
            double CA=Math.sqrt(Math.pow(matriz[0].x-matriz[2].x, 2)+Math.pow(matriz[0].y-matriz[2].y, 2));
            double semiperimetro=(AB+BC+CA)/2;
            double area=Math.sqrt(semiperimetro*(semiperimetro-AB)*(semiperimetro-BC)*(semiperimetro-CA));

            r_area.setText("Area: "+formato1.format(area));

            ladoAB.setText("Lado AB: "+formato1.format(AB));
            ladoBC.setText("Lado BC: "+formato1.format(BC));
            ladoCA.setText("Lado CA: "+formato1.format(CA));
            
            r_area.setForeground(Color.red);
            
            ladoAB.setForeground(Color.blue);
            ladoBC.setForeground(Color.blue);
            ladoCA.setForeground(Color.blue);
            
            double A= (180/Math.PI)*(Math.acos((Math.pow(BC, 2)+Math.pow(CA, 2)-Math.pow(AB, 2))/(2*BC*CA)));
            double B= (180/Math.PI)*(Math.acos((Math.pow(AB, 2)+Math.pow(CA, 2)-Math.pow(BC, 2))/(2*AB*CA)));
            double C= 180-A-B;

            g.drawString("θ=" +formato1.format(B)+"°", matriz[0].x,matriz[0].y);
            g.drawString("θ=" +formato1.format(C)+"°", matriz[1].x,matriz[1].y+10);
            g.drawString("θ=" +formato1.format(A)+"°", matriz[2].x,matriz[2].y);
        }
    }
    public void mouseReleased(MouseEvent e1)
    {

    }
}



