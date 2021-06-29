/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuloinscrito;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class CirculoInscrito extends JFrame
{

    /**
     * @param args the command line arguments
     */
    JRadioButton b2 = new JRadioButton("Circulo Circunscrito");
    JRadioButton b1 = new JRadioButton("Circulo Inscrito");
    JTextArea[][] texto = new JTextArea[3][2];
    JTextField [][] leer = new JTextField [3][2];
    JButton dibujar =new JButton ("Calcular");
    JButton borrar =new JButton ("Borrar");
    Puntos puntoA = new Puntos(0,0);
    Puntos puntoB = new Puntos(0,0);
    Puntos puntoC = new Puntos(0,0);
    Puntos puntoAB = new Puntos(0,0);
    Puntos puntoBC = new Puntos(0,0);
    Puntos puntoCA = new Puntos(0,0);
    JLabel respuesta = new JLabel ("");
    JLabel respuesta1 = new JLabel ("");
    JLabel respuesta2 = new JLabel ("");
    ButtonGroup grupo = new ButtonGroup();
    final int z=200;



    public static void main(String[] args)
    {
        //TODO code application logic here
        CirculoInscrito obj=new CirculoInscrito();
        obj.setSize(1000,1000);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




    public CirculoInscrito()
    {
        super("Circulo Inscrito");
        Container c =getContentPane();
        c.setLayout(null);
        c.add(dibujar);
        c.add(borrar);
        c.add(b2);
        c.add(b1);
        c.add(respuesta);
        c.add(respuesta1);
        c.add(respuesta2);
        grupo.add(b2);
        grupo.add(b1);
        b1.setSelected(true);
        b2.setSize(b2.getMinimumSize());
        b2.setBounds(190, 60, b2.getWidth(), 20);
        b1.setSize(b1.getMinimumSize());
        b1.setBounds(190, 20, b2.getWidth(), 20);
        dibujar.setSize(dibujar.getMinimumSize());
        dibujar.setBounds(190+b2.getWidth(), 20, dibujar.getWidth(), 20);
        dibujar.setBackground(Color.red);
        dibujar.setForeground(Color.white);
        borrar.setSize(borrar.getMinimumSize());
        borrar.setBounds(190+b2.getWidth(), 60, dibujar.getWidth(), 20);



        for(int x=0; x<3; x++)
        {
            for(int y=0; y<2; y++)
            {
                leer[x][y]=new JTextField();
                texto[x][y]=new JTextArea();
                c.add(texto[x][y]);
                c.add(leer[x][y]);
                leer[x][y].setBounds(-20+(70*(y+1)), -20+(20*(x+2)), 50, 20);
                texto[x][y].setBounds(30+(70*(y+1)), -20+(20*(x+2)), 20, 20);
                if(y==0)
                {
                    texto[x][y].setText("X"+(x+1));
                }
                else
                {
                    texto[x][y].setText("Y"+(x+1));
                }
                texto[x][y].setEditable(false);
                texto[x][y].setBackground(null);
                texto[x][y].setForeground(Color.blue);
                leer[x][y].setText("0");
            }
        }



        ActionListener oir = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                //Dibujar
                if(e.getSource()==dibujar)
                {
                    puntoA.x=Double.parseDouble(leer[0][0].getText());
                    puntoA.y=Double.parseDouble(leer[0][1].getText());
                    puntoB.x=Double.parseDouble(leer[1][0].getText());
                    puntoB.y=Double.parseDouble(leer[1][1].getText());
                    puntoC.x=Double.parseDouble(leer[2][0].getText());
                    puntoC.y=Double.parseDouble(leer[2][1].getText());

                    double AB=Math.sqrt(Math.pow(puntoB.x-puntoA.x, 2)+Math.pow(puntoB.y-puntoA.y, 2));
                    double BC=Math.sqrt(Math.pow(puntoC.x-puntoB.x, 2)+Math.pow(puntoC.y-puntoB.y, 2));
                    double CA=Math.sqrt(Math.pow(puntoA.x-puntoC.x, 2)+Math.pow(puntoA.y-puntoC.y, 2));
                    double semiperimetro=(AB+BC+CA)/2;
                    double radio = Math.sqrt(((semiperimetro-AB)*(semiperimetro-BC)*(semiperimetro-CA))/(semiperimetro));
                    double Radio = ((AB*BC*CA)/(4*semiperimetro*(Math.sqrt(((semiperimetro-AB)*(semiperimetro-BC)*(semiperimetro-CA))/(semiperimetro)))));


                    if(AB+CA>BC&&AB+BC>CA&&CA+BC>AB)
                    {


                        Graphics g;
                        g=getGraphics();
                        g.clearRect(0, 120, 1000, 1000);

                        g.setColor(Color.red);
                        g.drawLine((int) puntoA.x+z, (int) puntoA.y+z,(int) puntoB.x+z, (int) puntoB.y+z);
                        g.drawLine((int) puntoB.x+z, (int) puntoB.y+z,(int) puntoC.x+z, (int) puntoC.y+z);
                        g.drawLine((int) puntoC.x+z, (int) puntoC.y+z,(int) puntoA.x+z, (int) puntoA.y+z);

                        respuesta.setVisible(false);
                        respuesta1.setVisible(false);
                        respuesta2.setVisible(false);





                        //Circulo Inscrito
                        if(b1.isSelected()==true)
                        {



                            double razonAB=CA/BC;
                            double razonBC=AB/CA;
                            double razonCA=BC/AB;


                            puntoAB.x=((puntoA.x+(razonAB*puntoB.x))/(1+razonAB));
                            puntoAB.y=((puntoA.y+(razonAB*puntoB.y))/(1+razonAB));
                            puntoBC.x=((puntoB.x+(razonBC*puntoC.x))/(1+razonBC));
                            puntoBC.y=((puntoB.y+(razonBC*puntoC.y))/(1+razonBC));
                            puntoCA.x=((puntoC.x+(razonCA*puntoA.x))/(1+razonCA));
                            puntoCA.y=((puntoC.y+(razonCA*puntoA.y))/(1+razonCA));


                            double mAB=(puntoC.y-puntoAB.y)/(puntoC.x-puntoAB.x);
                            double mBC=(puntoA.y-puntoBC.y)/(puntoA.x-puntoBC.x);
                            double mCA=(puntoB.y-puntoCA.y)/(puntoB.x-puntoCA.x);


                            double cAB=(mAB*(-puntoAB.x))+puntoAB.y;
                            double cBC=(mBC*(-puntoBC.x))+puntoBC.y;
                            double cCA=(mCA*(-puntoCA.x))+puntoCA.y;

                            double X=(((mAB*puntoAB.x)-puntoAB.y-(mBC*puntoBC.x)+puntoBC.y)/(mAB-mBC));
                            double Y= ((mAB*(X-puntoAB.x))+puntoAB.y);

                            g.drawOval((int) (X+z-radio),(int) (Y+z-radio),(int) (radio*2),(int) (radio*2));

                            respuesta.setVisible(true);
                            respuesta.setText("Ecuacion AB="+mAB+"x+"+"y+"+cAB+"=0");
                            respuesta.setSize(respuesta.getMinimumSize());
                            respuesta.setBounds(200+dibujar.getWidth()+b2.getWidth(), 20, respuesta.getWidth(), 20);
                            respuesta.setForeground(Color.red);
                            respuesta1.setVisible(true);
                            respuesta1.setText("Ecuacion BC="+mBC+"x+"+"y+"+cBC+"=0");
                            respuesta1.setSize(respuesta1.getMinimumSize());
                            respuesta1.setBounds(200+dibujar.getWidth()+b2.getWidth(), 40, respuesta1.getWidth(), 20);
                            respuesta1.setForeground(Color.red);
                            respuesta2.setVisible(true);
                            respuesta2.setText("radio="+radio);
                            respuesta2.setSize(respuesta2.getMinimumSize());
                            respuesta2.setBounds(200+dibujar.getWidth()+b2.getWidth(), 60, respuesta2.getWidth(), 20);
                            respuesta2.setForeground(Color.red);
                        }//Fin Circulo Inscrito


                        //Circulo Circunscrito
                        if (b2.isSelected()==true)
                        {


                            puntoAB.x=((puntoA.x+puntoB.x)/(2));
                            puntoAB.y=((puntoA.y+puntoB.y)/(2));
                            puntoBC.x=((puntoB.x+puntoC.x)/(2));
                            puntoBC.y=((puntoB.y+puntoC.y)/(2));
                            puntoCA.x=((puntoC.x+puntoA.x)/(2));
                            puntoCA.y=((puntoC.y+puntoA.y)/(2));

                            double mAB=(double)(1)/-((puntoB.y-puntoA.y)/(puntoB.x-puntoA.x));
                            double mBC=(double)(1)/-((puntoC.y-puntoB.y)/(puntoC.x-puntoB.x));
                            double mCA=(double)(1)/-((puntoA.y-puntoC.y)/(puntoA.x-puntoC.x));

                            double cAB=(mAB*(-puntoAB.x))+puntoAB.y;
                            double cBC=(mBC*(-puntoBC.x))+puntoBC.y;
                            double cCA=(mCA*(-puntoCA.x))+puntoCA.y;

                            double X=(((mAB*puntoAB.x)-puntoAB.y-(mBC*puntoBC.x)+puntoBC.y)/(mAB-mBC));
                            double Y= ((mAB*(X-puntoAB.x))+puntoAB.y);

                            g.drawOval((int) (X+z-Radio),(int) (Y+z-Radio),(int) (Radio*2),(int) (Radio*2));


                            respuesta.setVisible(true);
                            respuesta.setText("Ecuacion AB="+mAB+"x+"+"y+"+cAB+"=0");
                            respuesta.setSize(respuesta.getMinimumSize());
                            respuesta.setBounds(200+dibujar.getWidth()+b2.getWidth(), 20, respuesta.getWidth(), 20);
                            respuesta.setForeground(Color.red);
                            respuesta1.setVisible(true);
                            respuesta1.setText("Ecuacion BC="+mBC+"x+"+"y+"+cBC+"=0");
                            respuesta1.setSize(respuesta1.getMinimumSize());
                            respuesta1.setBounds(200+dibujar.getWidth()+b2.getWidth(), 40, respuesta1.getWidth(), 20);
                            respuesta1.setForeground(Color.red);
                            respuesta2.setVisible(true);
                            respuesta2.setText("radio="+Radio);
                            respuesta2.setSize(respuesta2.getMinimumSize());
                            respuesta2.setBounds(200+dibujar.getWidth()+b2.getWidth(), 60, respuesta2.getWidth(), 20);
                            respuesta2.setForeground(Color.red);
                        }//Fin Circulo Circunscrito
                    }//fin existe triangulo


                    else
                    {
                        respuesta.setVisible(true);
                        respuesta.setText("Error en los datos.");
                        respuesta.setSize(respuesta.getMinimumSize());
                        respuesta.setBounds(200+dibujar.getWidth()+b2.getWidth(), 20, respuesta.getWidth(), 20);
                        respuesta.setForeground(Color.red);
                    }
                }//fin Dibujar




                //borrar
                if(e.getSource()==borrar)
                {
                    respuesta.setVisible(false);
                    respuesta1.setVisible(false);
                    respuesta2.setVisible(false);
                    c.repaint();

                }//fin Borrar


            }
        };
        dibujar.addActionListener(oir);
        borrar.addActionListener(oir);
    }

}
//150,150;20,30;370,150