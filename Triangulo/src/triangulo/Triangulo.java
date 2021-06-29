/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulo;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JTextArea;




public class Triangulo extends JFrame{
    int y5;
    
    JButton existe = new JButton ("Existe el Triangulo a Calcular?");
    JButton pintar = new JButton ("Pintar el Triangulo");
    JButton borrar = new JButton ("Borrar el Triangulo");
    JButton tipo = new JButton ("Tipo de Triangulo");
    JButton calculoArea = new JButton ("Calcular Area del Triangulo");
    JTextArea escribirExistencia = new JTextArea (" ");
    /*JTextArea lado1 = new JTextArea("a");
    JLabel lado2 = new JLabel("b");
    JLabel lado3 = new JLabel("c");*/
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        double a,b,c,x,y,x1,y1,x2,y2,s,area,altura;
        x=y=x1=y1=x2=y2=area=0;
        int existencia,tipoTriangulo=0;
        
        
        
        System.out.println("Digite la medida del primer lado:");
        a=in.nextDouble();
        System.out.println("Digite el valor para el segundo lado:");
        b=in.nextDouble();
        System.out.println("Por ultimo el tercer lado:");
        c=in.nextDouble();
        
        
        
        if(a+b>c&&a+c>b&&b+c>a){
            existencia=1;
            s=(a+b+c)/2;
            area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
            altura=(2*area)/a;
            x=500-a/2;
            y=500-altura/2;
            x1=x+a;
            y1=y;
            x2=x1-Math.sqrt(Math.pow(b,2)-Math.pow(altura,2));
            y2=y+altura;
            
            if(a==b&&a==c){
                tipoTriangulo=0;
            }else if(a==b&&a!=c||a==c&&a!=b||b==c&&b!=a){
                tipoTriangulo=1;
            }else{
                tipoTriangulo=2;
            }
        }else{
            existencia=0;
        }
        
        
        Triangulo obj=new Triangulo(a,b,c,x,y,x1,y1,x2,y2,existencia,area,tipoTriangulo);
        obj.setSize(1000,1000);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    
    Triangulo (double a,double b,double c, double x, double y, double x1, double y1, double x2, double y2,int existencia,double area,int tipoTriangulo){
        
        super("Triangulo");
        
        Container t= getContentPane();
        t.setLayout(new FlowLayout());
        t.add(existe);
        t.add(pintar);
        t.add(borrar);
        t.add(tipo);
        t.add(calculoArea);
        t.add(escribirExistencia);
        escribirExistencia.setForeground(Color.red);
        escribirExistencia.setEditable(false);
        
        
        ActionListener oir = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(existencia==1){
                    escribirExistencia.setText("El Triangulo para las medidas dadas SI existe...");
                }else{
                    escribirExistencia.setText("El Triangulo para las medidas dadas NO existe...");
                }   
            }
        };existe.addActionListener(oir);
        
        
        ActionListener oir1 = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(existencia==1){
                    Graphics g;
                    g=getGraphics();
                    g.setColor(Color.red);
                    g.drawLine((int) x,(int) y,(int) x1,(int) y1);
                    g.drawLine((int)x1, (int) y1, (int) x2, (int) y2);
                    g.drawLine((int) x2, (int) y2,(int) x,(int) y);
                    y5=3;
                }else{
                    escribirExistencia.setText("El Triangulo para las medidas dadas NO existe...");
                }
            }
        };pintar.addActionListener(oir1);
        
        
        ActionListener oir2 = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(existencia==1){
                    Graphics g;
                    g=getGraphics();
                    g.clearRect((int) x,(int) y,(int) x1,(int) y2);
                }else{
                    escribirExistencia.setText("El Triangulo para las medidas dadas NO existe...");
                }
            }
        };borrar.addActionListener(oir2);
        
        
        ActionListener oir4 = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(existencia==1){
                    if(tipoTriangulo==0){
                        escribirExistencia.setText("El Triangulo para las medidas dadas es: EQUILATERO ");
                    }else if(tipoTriangulo==1){
                        escribirExistencia.setText("El Triangulo para las medidas dadas es: ISOCELES ");
                    }else if(tipoTriangulo==2){
                        escribirExistencia.setText("El Triangulo para las medidas dadas es: ESCALENO ");
                    }
                }else{
                    escribirExistencia.setText("El Triangulo para las medidas dadas NO existe...");
                }
            }
        };tipo.addActionListener(oir4);
        
        
        ActionListener oir5 = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(existencia==1){
                    escribirExistencia.setText("El Area del Triangulo para las medidas dadas es: "+area);
                }else{
                    escribirExistencia.setText("El Triangulo para las medidas dadas NO existe...");
                }
            }
        };calculoArea.addActionListener(oir5);
    }
}
