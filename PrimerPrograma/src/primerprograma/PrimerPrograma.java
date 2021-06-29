/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerprograma;

import java.util.Scanner;

/**
 *
 * @author jefer
 */
public class PrimerPrograma {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    double a,b;
    System.out.print("digite a");
    a= sc.nextDouble();
    System.out.print("digite b");
    b= sc.nextDouble();
    sumardosnumeros objeto = new sumardosnumeros(a,b);
    objeto.sumar();
    double h = objeto.mostrar();
    System.out.println("respuesta="+h);
  }
 
}