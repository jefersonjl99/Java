/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambiobase;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class CambioBase extends JFrame implements ActionListener {

    Binario binario = new Binario();
    Hexadecimal hexadecimal = new Hexadecimal();
    Octal octal = new Octal();

    JComboBox cambio = new JComboBox();

    JTextField decimal = new JTextField("0");

    JTextArea texto1 = new JTextArea("Decimal:");
    JTextArea texto = new JTextArea("convertir a...");

    JLabel respuesta = new JLabel("");
    JLabel salida = new JLabel("");
    JLabel salidaExponente = new JLabel("");
    JLabel salidaMantisa = new JLabel("");

    int[] bits = new int[32];
    int[] mantisa = new int[64];
    int[] exponente = new int[8];
    int[] tamaños = new int[3];
    char[] caracter = new char[64];
    int i, j, numero, signo;

    public static void main(String[] args) {
        // TODO code application logic here
        CambioBase obj = new CambioBase();
        obj.setSize(500, 340);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
    }

    CambioBase() {
        super("Cambio Base");
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);

        cambio.addItem("Binario");
        cambio.addItem("Hexadecimal");
        cambio.addItem("Octal");
        cambio.addItem("Binario en Formato IEEE");

        c.add(texto1);
        c.add(decimal);
        c.add(texto);
        c.add(cambio);
        c.add(respuesta);
        c.add(salida);
        c.add(salidaExponente);
        c.add(salidaMantisa);

        texto1.setBounds(150, 30, 200, 20);
        texto1.setBackground(null);
        texto1.setEditable(false);
        

        decimal.setBounds(150, 60, 200, 20);
        decimal.setBackground(Color.white);

        texto.setBounds(150, 80, 200, 20);
        texto.setBackground(null);
        texto.setEditable(false);

        cambio.setBounds(150, 100, 200, 20);
        cambio.addActionListener(this);

        respuesta.setBounds(150, 150, 200, 20);
        respuesta.setForeground(Color.red);

        salida.setBounds(150, 170, 300, 20);
        salida.setForeground(Color.red);

        salidaExponente.setBounds(150, 190, 300, 20);
        salidaExponente.setForeground(Color.red);

        salidaMantisa.setBounds(150, 210, 300, 20);
        salidaMantisa.setForeground(Color.red);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int opcion = cambio.getSelectedIndex();

        //decimal a binario
        if (opcion == 0) {

            for (j = 0; j < 64; j++) {
                caracter[j] = 0;
            }
            for (j = 0; j < 32; j++) {
                bits[j] = 0;
            }
            salidaMantisa.setText(null);
            salidaExponente.setText(null);

            numero = Integer.parseInt(decimal.getText());

            i = binario.dec_bin(numero, bits);

            for (j = 0; j < i; j++) {
                caracter[j] = (char) bits[j];
            }

            binario.bin_ascci(caracter, i);

            respuesta.setText("El numero " + decimal.getText() + " en Binario es:");
            salida.setText(String.valueOf(caracter));
        }//decimal a binario

        //decimal a hexadecimal
        if (opcion == 1) {

            for (j = 0; j < 64; j++) {
                caracter[j] = 0;
            }
            for (j = 0; j < 32; j++) {
                bits[j] = 0;
            }
            salidaMantisa.setText(null);
            salidaExponente.setText(null);

            numero = Integer.parseInt(decimal.getText());

            i = binario.dec_bin(numero, bits);

            i = hexadecimal.bin_hex(bits, i);

            int k = 0;
            for (j = i; j >= 0; j--) {
                caracter[j] = (char) bits[k];
                k++;
            }

            respuesta.setText("El numero " + decimal.getText() + " en Hexadecimal es:");
            salida.setText("0x" + String.valueOf(caracter));
        }//a hexadecimal

        //octal
        if (opcion == 2) {
             for (j = 0; j < 64; j++) {
                caracter[j] = 0;
            }
             for (j = 0; j < 32; j++) {
                bits[j] = 0;
            }
            salidaMantisa.setText(null);
            salidaExponente.setText(null);

            numero = Integer.parseInt(decimal.getText());

            i = binario.dec_bin(numero, bits);

            i = octal.bin_octal(bits, i);

            int k = 0;
            for (j = i; j >= 0; j--) {
                caracter[j] = (char) bits[k];
                k++;
            }

            respuesta.setText("El numero " + decimal.getText() + " en Octal es:");
            salida.setText("0" + String.valueOf(caracter));
            
        }//octal

        //iEEE
        if (opcion == 3) {
            for (j = 0; j < 64; j++) {
                caracter[j] = 0;
            }
            for (j = 0; j < 32; j++) {
                bits[j] = 0;
            }

            double num = Double.parseDouble(decimal.getText());
            signo = 0;
            if (num < 0) {
                signo = 1;
                num *= -1;
            }

            binario.float_bin(num, exponente, mantisa, tamaños);

            for (j = 0; j < tamaños[0]; j++) {
                caracter[j] = (char) exponente[j];
            }

            binario.bin_ascci(caracter, tamaños[0]);

            respuesta.setText("El numero " + decimal.getText() + " en Binario es:");
            if (signo == 1) {
                salida.setText("Signo= 1");
            } else {
                salida.setText("Signo= 0");
            }

            salidaExponente.setText("Exponente: " + String.valueOf(caracter));

            for (j = 0; j < tamaños[1]; j++) {
                caracter[j] = (char) mantisa[j];
            }

            binario.bin_ascci(caracter, tamaños[1]);

            salidaMantisa.setText("Mantiza: " + String.valueOf(caracter));
        }//IEEE

    }//accion
}//Clase

/*


for( i=0; i<50; i++)
            {
                numero[i]=0;
            }



            num=Integer.parseInt(decimal.getText());

            signo =0;
            if(num<0)
            {
                num*=-1;
                signo=1;
            }
            
            
            
            respuesta.setText("El numero "+decimal.getText()+" en binario es:");
            System.out.println("El numero decimal "+num+" equivale en Binario a: ");

            
            
            i=0;
            for(dividendo = num; dividendo > 0; i++)
            {
                a[i] = dividendo%2;
                cociente = dividendo/2;
                dividendo=cociente;
                if(num==0)
                    break;
                numero[i]=(char)(a[i]+48);
            }
            
            
            invertir(numero);
            if(signo==1)
            {
                System.out.println("1 "+String.valueOf(numero));
                out.setText("1 "+String.valueOf(numero));
            }
            else
            {
                System.out.println("0 "+String.valueOf(numero));
                out.setText("0 "+String.valueOf(numero));
            }
            for(j=i-1; j>=0; j--)
            {
                System.out.print(""+a[j]);
            }
            System.out.println("");











for( i=0; i<32; i++)
            {
                caracter[i]=0;
            }
            num=Integer.parseInt(decimal.getText());

            
            signo =0;
            if(num<0)
            {
                num*=-1;
                signo=1;
            }
            respuesta.setText("El numero "+decimal.getText()+" en Hexadecimal es:");
            System.out.println("El numero decimal "+num+" equivale en Hexadecimal a: ");

            i=0;
            for(dividendo = num; dividendo > 0; i++)
            {
                a[i] = dividendo%16;
                cociente = dividendo/16;
                dividendo=cociente;
            }


            for( j=i-1; j>=0; j--)
            {
                if(a[j]==10)
                {
                    caracter[j]= 'A';
                    System.out.print("A");
                }
                if(a[j]==11)
                {
                    caracter[j]= 'B';
                    System.out.print("B");
                }
                if(a[j]==12)
                {
                    caracter[j]= 'C';
                    System.out.print("C");
                }
                if(a[j]==13)
                {
                    caracter[j]= 'D';
                    System.out.print("D");
                }
                if(a[j]==14)
                {
                    caracter[j]= 'E';
                    System.out.print("E");
                }
                if(a[j]==15)
                {
                    caracter[j]= 'F';
                    System.out.print("F");
                }
                if(a[j]<10)
                {
                    caracter[j]=(char)(a[j]+48);
                    System.out.print(""+a[j]);
                }

            }
            System.out.println("");

            invertir(caracter);
            if(signo==1)
            {
                System.out.println("-"+String.valueOf(caracter));
                out.setText("-"+String.valueOf(caracter));
            }
            else
            {
                System.out.println(String.valueOf(caracter));
                out.setText(String.valueOf(caracter));
            }
 */
