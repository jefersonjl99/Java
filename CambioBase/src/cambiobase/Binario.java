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
public class Binario {

    

    public int dec_bin(int numero, int bites[]) {
        
        
        int dividendo, cociente,i=0;
        if(numero==0){
            i=1;
            bites[0]=0;
            System.out.println("0");
        }
        //si el muero es mayo o igual a 0
        if (numero > 0) {
            for (dividendo = numero; dividendo > 0; i++) {

                bites[i] = dividendo % 2;
                cociente = dividendo / 2;
                dividendo = cociente;

                if (numero == 0) {
                    break;
                }
            }

            //Da vuelta al arreglo y lo muestra
            for (int j = 0; j < i / 2; j++) {
                int temporal = bites[j];
                int indiceContrario = i - j - 1;
                bites[j] = bites[indiceContrario];
                bites[indiceContrario] = temporal;
            }
            System.out.print("\n"+numero+" Mayor a 0: \n!!!!  ");
            for (int j = 0; j < i; j++) {
                System.out.print(bites[j]);
            }
            System.out.println("  !!!!");
            //Da vuelta al arreglo y lo muestra

        }//si el numero es mayor o igual a 0

        
        //si el numero es menor a 0
        if (numero < 0) {

            numero *= -1;
            int h = 0;

            //Calcula el binario
            for (dividendo = numero; dividendo > 0; i++) {

                bites[i] = dividendo % 2;
                cociente = dividendo / 2;
                dividendo = cociente;

                if (numero == 0) {
                    break;
                }
            }
            //Calcula el binario

            //Da vuelta al arreglo y lo muestra
            i = 32;
            for (int j = 0; j < i / 2; j++) {
                int temporal = bites[j];
                int indiceContrario = i - j - 1;
                bites[j] = bites[indiceContrario];
                bites[indiceContrario] = temporal;
            }
            System.out.print("\n"+numero+" Menor a 0:\n!!!!  ");
            for (int j = 0; j < i; j++) {
                System.out.print(bites[j]);
            }
            System.out.println("  !!!!");
            //Da vuelta al arreglo y lo muestra

            //Complemento a 2
            for (int j = i - 1; j >= 0; j--) {
                if (bites[j] == 1) {
                    h = j - 1;
                    break;
                }
            }
            for (int j = h; j >= 0; j--) {
                if (bites[j] == 1) {
                    bites[j] = 0;
                } else {
                    bites[j] = 1;
                }
            }
            System.out.print("\nComplemento a 2:\n!!!!  ");
            for (int j = 0; j < i; j++) {
                System.out.print(bites[j]);
            }
            System.out.println("  !!!!");
            //Complemento a 2

        }//si el numero es menor a 0

        return i;

    }

    
    
    
    
    
    
    
    
    
    //Float a binario
    public void float_bin(double numero, int[] exponente, int[] mantisa,int [] tama??os) {

        int numExponente,movimientos,tama??oEntero,tama??oDecimal=32,tama??oMantisa,tama??oExponente;
        double parteDecimal,decimales;
        int parteEntera; 
        int[] matrizNum=new int[64];
        
        parteDecimal = numero % 1;
        parteEntera = (int) (numero - parteDecimal);

        String str = String.valueOf(numero);str=(str.substring(str.indexOf('.') + 1));

        tama??oEntero = dec_bin(parteEntera, matrizNum);

        //Imprime la parte entera en binario
        System.out.println("\nParte entera:" + parteEntera);
        for (int j = 0; j < tama??oEntero; j++) {
            System.out.print(matrizNum[j]);
        }
        System.out.println("");
        //Imprime la parte entera en binario
        
        int[] b = new int[tama??oDecimal];
        for (int j = 0; j < tama??oDecimal; j++) {
            decimales = (parteDecimal * 2);
            parteDecimal = decimales % 1;
            b[j] = (int) (decimales - parteDecimal);
        }

        //Imprime Parte decimal en binario
        System.out.println("\nParte decimal:" + str);
        for (int j = 0; j < tama??oDecimal; j++) {
            System.out.print(b[j]);
        }
        System.out.println("");
        //Imprime Parte decimal en binario

        //Crea el arreglo con la parte entera y decimal y lo muestra
        int k = 0;
        for (int j = 0; j < tama??oEntero + tama??oDecimal; j++) {
            if (j >= tama??oEntero) {
                matrizNum[j] = b[k];
                k++;
            }
        }
        System.out.println("\nNumero Completo:");
        for (int j = 0; j < tama??oEntero + tama??oDecimal; j++) {
            if (j == tama??oEntero) {
                System.out.print(".");
            }
            System.out.print(matrizNum[j]);
        }
        System.out.println("");
        //Crea el arreglo con la parte entera y decimal
        
        //Busca el primer 1 en el arreglo y guarda la siguiente posicion a este
        for (int j = 0; j < tama??oEntero + tama??oDecimal; j++) {
            if (matrizNum[j] == 1) {
                k = j + 1;
                break;
            }
        }//Busca el primer 1 en el arreglo y guarda la siguiente posicion a este

        //Calcula la cantidad de movimientos y resta a 27
        if(numero==0){
            movimientos=0;
            numExponente =0;
        }else{
            movimientos = (tama??oEntero - k);
            numExponente = 127 + movimientos;
        }
        //Calcula la cantidad de movimientos y resta a 27
        
        //Calcula el exponenete en binario
        tama??oExponente=dec_bin(numExponente, exponente);
        tama??os[0]=tama??oExponente;
        //Calcula el exponenete en binario
        
        //Llena la mantiza con el binario despues del primer 1
        int h = 0;
        tama??oMantisa=(tama??oEntero + tama??oDecimal);
        for (int j = k; j < tama??oMantisa; j++) {
            mantisa[h] = matrizNum[j];
            h++;
        }//Llena la mantiza con el binario despues del primer 1

        //Calcula el tama??o de la mantisa segun las posiciones corridas hasta el 1
        tama??oMantisa=tama??oMantisa-k;
        tama??os[1]=tama??oMantisa;
        //Calcula el tama??o de la mantisa segun las posiciones corridas hasta el 1
        
        //Iprime la mantisa
        System.out.println("\nMantisa:");
        for (int j = 0; j < tama??oMantisa; j++) {
            System.out.print(mantisa[j]);
        }
        System.out.println("");
        //Iprime la mantisa

        System.out.println("\nMovimientos:" + movimientos);

        System.out.println("\nExponente:");
        for (int j = 0; j < tama??oExponente; j++) {

            System.out.print(exponente[j]);
        }
        System.out.println("");
        
    }//FLoat a binario

    
    
    //Genera los caracteres correspondientes en ascci
    public void bin_ascci(char a[], int i) {
        for (int j = 0; j < i; j++) {
            a[j] += 48;
        }
    }
    //Genera los caracteres correspondientes en ascci
}
