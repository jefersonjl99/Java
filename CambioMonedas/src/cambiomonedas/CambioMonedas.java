/*
 * Copyright <2021> <JEFERSON JIMENEZ>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining 
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package cambiomonedas;

import abstracto.Comun;
import fabrica.Fabrica;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Jimenez
 */
public class CambioMonedas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Comun comun;//definicion del objeto para la clase Micomun
        Fabrica fabrica;//definicion del objeto para mi fabrica
        double valor;
        int moneda;

        valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dinero en pesos colombianos a convertir: "));
        moneda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion segun corresponda a la moneda para convertir:\n1) Dolar\n2) Euro"
                + "\n3) Libra\n4) Rublo\n5) Yen\n6) Yuan"));

        fabrica = new Fabrica(moneda); //instancia de objeto de la clase fabrica
        comun = fabrica.crear_selecion(); //asignacion de un alias para el metodo crear_seleccion
        String salir = " " + comun.cambio(valor);//asigna el string

        System.out.println(salir);//imprime

    }

}
