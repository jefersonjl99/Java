/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecuaciontercergrado;

import java.util.Scanner;

/**
 *
 * @author jefer
 */
public class EcuacionTercerGrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a,b,c,d;
        
        Scanner in = new Scanner(System.in);
        a=in.nextInt();
        b=in.nextInt();
        c=in.nextInt();
        d=in.nextInt();
        Raices objeto=new Raices(a,b,c,d);
//System.out.println(+objeto.raiz1());
        System.out.println(+objeto.raiz2());
        System.out.println(+objeto.raiz3());

        
        
        
    }
    
}
