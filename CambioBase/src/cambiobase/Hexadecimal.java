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
public class Hexadecimal {

    public int bin_hex(int[] a, int i) {

        int[][] bytes = new int[8][4];
        String num = "";
        char[] caracteres = new char[9];
        int h = i-1, hex;
        int divisiones;

        System.out.println("Binario recibido en clase Hexadecimal:");
        for (int j = 0; j < i; j++) {
            System.out.print(a[j]);
        }
        System.out.println("...\n");

        for (int j = 0; j < 8; j++) {
            for (int k = 3; k >=0; k--) {
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
                    case 1000:
                        caracteres[j]='8';
                        break;
                    case 1001:
                        caracteres[j]='9';
                        break;
                    case 1010:
                        caracteres[j]='A';
                        break;
                    case 1011:
                        caracteres[j]='B';
                        break;
                    case 1100:
                        caracteres[j]='C';
                        break;
                    case 1101:
                        caracteres[j]='D';
                        break;
                    case 1110:
                        caracteres[j]='E';
                        break;
                    case 1111:
                        caracteres[j]='F';
                        break;
                    default:
                        break;
                }
            num="";
        }
        divisiones=i/4;
        if(divisiones*4==i){
            divisiones=Math.floorDiv(i, 4)-1;
        }else{
            divisiones=Math.floorDiv(i, 4);
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
