/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complejidadmultmatrices;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jefer
 */
public class ComplejidadMultMatrices extends JFrame implements ActionListener {

    Color color = new Color(50, 93, 127);
    JLabel texto = new JLabel();
    
    JButton boton_caso1 = new JButton("Peor Caso");
    JButton boton_caso2 = new JButton("Mejor Caso");
    JButton boton_caso3 = new JButton("Aleatorio");
    JButton boton_caso4 = new JButton("Aleatorio");

    Font fuente = new Font("TimesRoman", Font.BOLD, 20);

    int m = 4, n = 100, cont = 1, t;
    int a[] = new int[n];
    int b[] = {35, 453, 1325, 543, 56, 1, 2, 3};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ComplejidadMultMatrices obj = new ComplejidadMultMatrices();
        obj.setSize(340, 400);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);

    }

    ComplejidadMultMatrices() {
        super("Operaciones Elementales");

        Container N = getContentPane();
        N.setLayout(null);
        N.setBackground(color);

        N.add(boton_caso1);
        N.add(boton_caso2);
        N.add(boton_caso3);
        N.add(boton_caso4);
        N.add(texto);

        boton_caso1.setBounds(20, 20, 100, 20);
        boton_caso2.setBounds(120, 20, 100, 20);
        boton_caso3.setBounds(220, 20, 100, 20);
        boton_caso4.setBounds(220, 40, 100, 20);
        texto.setBounds(20, 40, 300, 360);
        texto.setFont(fuente);
        texto.setForeground(Color.WHITE);

        boton_caso1.addActionListener(this);
        boton_caso2.addActionListener(this);
        boton_caso3.addActionListener(this);
        boton_caso4.addActionListener(this);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////caso 2
        ///////////////////////////////////////////////////////////////caso 3
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_caso1) {
            System.out.println("Caso 1: 100 - 1...");

            cont = 1;

            for (int i = 0; i < n; i++) {
                a[i] = n - i;
            }

            for (int i = 0; i < n; i++) {
                System.out.print("\t" + a[i]);
            }
            System.out.println("\n");

            for (int i = 0; i < n - 1; i++) {//4(n-1)+2
                cont += 5;
                for (int j = i + 1; j < n; j++) {//12(n*n - ((n-1)n)/2 - n)(n-1)
                    if (a[i] > a[j]) {//
                        t = a[i];
                        a[i] = a[j];
                        a[j] = t;
                        cont += 7;
                    }
                    cont += 5;
                }
                cont++;
            }
            cont += 2;
            //12(n*n - ((n-1)n)/2 - n)+2
            System.out.println("(((12*((n*n) - (((n*n)-n)/2) - n)))+6*(n-1))+3:  " + ((((12 * ((n * n) - (((n * n) - n) / 2) - n))) + 6 * (n - 1)) + 3));
            System.out.println("contador:  " + cont);
            System.out.println("\n");
            texto.setText("<html>Mejor caso:<p>Formula 6n^2-3: <html>" + ((((12 * ((n * n) - (((n * n) - n) / 2) - n))) + 6 * (n - 1)) + 3) + "<p>Contador: " + cont + "<p>Complejidad: O(n^2) cuadratica");
        }
        if (e.getSource() == boton_caso2) {
            for (int i = 0; i < n; i++) {
                a[i] = i;
            }

            cont = 1;
            System.out.println("Caso 2: 0 - 99...");

            for (int i = 0; i < n; i++) {
                System.out.print("\t" + a[i]);
            }
            System.out.println("\n");

            for (int i = 0; i < n - 1; i++) {//4(n-1)+2
                cont += 5;
                for (int j = i + 1; j < n; j++) {//12(n*n - ((n-1)n)/2 - n)(n-1)
                    if (a[i] > a[j]) {//
                        t = a[i];
                        a[i] = a[j];
                        a[j] = t;
                        cont += 7;
                    }
                    cont += 5;
                }
                cont++;
            }
            cont += 2;
            //12(n*n - ((n-1)n)/2 - n)+2
            System.out.println("(((5*((n*n) - (((n*n)-n)/2) - n)))+6*(n-1))+3:  " + ((((5 * ((n * n) - (((n * n) - n) / 2) - n))) + 6 * (n - 1)) + 3));
            System.out.println("contador:  " + cont);
            System.out.println("\n\n");

            texto.setText("<html>Peor caso:<p>Formula (5n^2+7n-6)/2: <html>" + ((((5 * ((n * n) - (((n * n) - n) / 2) - n))) + 6 * (n - 1)) + 3) + "<p>Contador: " + cont + "<p>Complejidad: O(n^2) cuadratica");

        }
        if (e.getSource() == boton_caso3) {
            for (int i = 0; i < n; i++) {
                a[i] = (int) (Math.random() * 100);
            }

            cont = 1;
            System.out.println("Caso 3: Aleatorio");

            for (int i = 0; i < n; i++) {
                System.out.print("\t" + a[i]);
            }
            System.out.println("\n");

            for (int i = 0; i < n - 1; i++) {//4(n-1)+2

                cont += 5;
                for (int j = i + 1; j < n; j++) {//12(n*n - ((n-1)n)/2 - n)(n-1)
                    if (a[i] > a[j]) {//
                        t = a[i];
                        a[i] = a[j];
                        a[j] = t;
                        cont += 7;
                    }
                    cont += 5;
                }
                cont++;
            }
            cont += 2;
            //12(n*n - ((n-1)n)/2 - n)+2
            System.out.println("((((5 * ((n * n) - (((n * n) - n) / 2) - n)) + ((7 * ((n * n) - (((n * n) - n) / 2) - n))/2) + (6 * (n - 1))) + 3))): " + ((((5 * ((n * n) - (((n * n) - n) / 2) - n)) + ((7 * ((n * n) - (((n * n) - n) / 2) - n)) / 2) + (6 * (n - 1))) + 3)));
            System.out.println("contador:  " + cont);

            texto.setText("<html>Aleatorio:<p>Formula (17n^2+7n-12)/4: <html>" + ((((5 * ((n * n) - (((n * n) - n) / 2) - n)) + ((7 * ((n * n) - (((n * n) - n) / 2) - n)) / 2) + (6 * (n - 1))) + 3)) + "<p>Contador: " + cont + "<p>Complejidad: O(n^2)");
        }
        if (e.getSource() == boton_caso4) {
            int res[][] = new int[10][b.length];
            int num, cifras = 0;
            
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < b.length; j++) {

                }
            }

        }
    }

}

/*
        int b[][] = new int[n][n];
        int c[][] = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=j+i+1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                b[i][j]=j+i+1;
            }
        }
///////////////////////////////////////////////////////////////////////////////////
        for(int i=0;i<m;i++){//(1+2m+1)
            cont+=3;
            for(int j=0;j<n;j++){//(1+2n+1)*m
                cont+=3;
                for(int k=0;k<n;k++){//(1+2n+1)*n*m
                    c[i][j]+=a[i][k]*b[k][j]; //11n*n*m
                    cont+=13;
                }
                cont++;
            }
            cont++;
        }
        cont++;
////////////////////////////////////////////////////////////////////////////////////
//2m+2+(2n+2)m+(2n+2)mn+11mnn=2m+2+2mn+2m+2mnn+2mn+11mnn=13mnn+4mn+4m+2
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+"  ");
            }System.out.println("");
        }System.out.println("\n");
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(b[i][j]+"  ");
            }System.out.println("");
        }System.out.println("\n");
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(c[i][j]+"  ");
            }System.out.println("");
        }
        
        System.out.println("\n9mnn+2mn+2nn+4m+2n+2: "+(13*m*n*n+4*m*n+4*m+2));
        System.out.println("\nComplejidad: "+cont);
 */
