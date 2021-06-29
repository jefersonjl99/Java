/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambiobase;

/**
 *
 * @author jefer
 */
public class Octal {
    
     public int bin_octal(int[] a, int i) {

        int[][] bytes = new int[11][3];
        String num = "";
        char[] caracteres = new char[12];
        int h = i-1, octal;
        int divisiones;

        System.out.println("Binario recibido en clase Octal:");
        for (int j = 0; j < i; j++) {
            System.out.print(a[j]);
        }
        System.out.println("...\n");

        for (int j = 0; j < 11; j++) {
            for (int k = 2; k >=0; k--) {
                if(h>=0){
                    bytes[j][k] = a[h];
                    h--;
                }else{
                    break;
                }
            }
        }

        
        
        for (int j = 0; j < 11; j++) {
            for (int k = 0; k < 3; k++) {
                num += bytes[j][k];
            }
            octal = Integer.parseInt(num);  
            switch (octal) {
                    case 0:
                        caracteres[j]='0';
                        break;
                    case 1:
                        caracteres[j]='1';
                        break;
                    case 10:
                        caracteres[j]='2';
                        break;
                    case 11:
                        caracteres[j]='3';
                        break;
                    case 100:
                        caracteres[j]='4';
                        break;
                    case 101:
                        caracteres[j]='5';
                        break;
                    case 110:
                        caracteres[j]='6';
                        break;
                    case 111:
                        caracteres[j]='7';
                        break;
                    default:
                        break;
                }
            num="";
        }
        divisiones=i/3;
        if(divisiones*3==i){
            divisiones=Math.floorDiv(i, 3)-1;
        }else{
            divisiones=Math.floorDiv(i, 3);
        }
        System.out.print("El numero: \n");
        for (int j=divisiones; j>=0; j--) {
            System.out.print(caracteres[j]);
            a[j]=(int)caracteres[j];
        }System.out.println("");
        
        i=divisiones;
        return i;
    }
    
}


/*

public int bin_octal(int[] a, int i) {

        int[][] bytes = new int[12][3];
        String num = "";
        char[] caracteres = new char[12];
        int h = i-1, hex;
        int divisiones;

        System.out.println("Binario recibido en clase Octal:");
        for (int j = 0; j < i; j++) {
            System.out.print(a[j]);
        }
        System.out.println("...\n");

        for (int j = 0; j < 12; j++) {
            for (int k = 2; k >=0; k--) {
                if(h>=0){
                    bytes[j][k] = a[h];
                    h--;
                }else{
                    break;
                }
            }
        }

        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 4; k++) {
                System.out.print(bytes[j][k]);
            }
            System.out.println("");
        }

        for (int j = 0; j < 12; j++) {
            for (int k = 0; k < 3; k++) {
                num += bytes[j][k];
            }
            hex = Integer.parseInt(num);  
            switch (hex) {
                    case 0:
                        caracteres[j]='0';
                        break;
                    case 1:
                        caracteres[j]='1';
                        break;
                    case 10:
                        caracteres[j]='2';
                        break;
                    case 11:
                        caracteres[j]='3';
                        break;
                    case 100:
                        caracteres[j]='4';
                        break;
                    case 101:
                        caracteres[j]='5';
                        break;
                    case 110:
                        caracteres[j]='6';
                        break;
                    case 111:
                        caracteres[j]='7';
                        break;
                    
                    default:
                        break;
                }
            System.out.println(hex);
            num="";
        }
        divisiones=i/3;
        if(divisiones*3==i){
            divisiones=Math.floorDiv(i, 3)-1;
        }else{
            divisiones=Math.floorDiv(i, 3);
        }
        
        System.out.print("los caracteres:");
        for (int j=divisiones; j>=0; j--) {
            System.out.print(caracteres[j]);
            a[j]=(int)caracteres[j];
        }System.out.println("");
        
        i=divisiones;
        return i;

    }

*/