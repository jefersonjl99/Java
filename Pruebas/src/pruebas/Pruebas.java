/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author jefer
 */
public class Pruebas {

    public static void main(String[] args) {
        System.out.println(f(16));
    }
    
    public static int f(int n){
        if(n==1){
            return 1;
        }if(n==2){
            return 8;
        }
        return 4*f(n/2)+n*n;
    }
    
    
}
