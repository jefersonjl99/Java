/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraccionescontinuas;

/**
 *
 * @author jefer
 */
public class Fracciones {

    int numerador, denominador,residuo,i=0;

    void asignar(int n, int d) {
        this.numerador = n;
        this.denominador = d;
    }
    
    int  calcular_arreglo(int []cocientes) {
        
        int cociente;
        i=0;
        cociente=numerador/denominador;
        residuo=numerador%denominador;
        while(residuo!=0){
            cocientes[i] =cociente;
            numerador=denominador;
            denominador=residuo;
            cociente=numerador/denominador;
            residuo=numerador%denominador;
            i++;
        }
        cocientes[i]=cociente;
        i++;
        
        
       return i;
    }
    
    double calcular_cociente(int [] cocientes){
        
        double cociente;
        i=calcular_arreglo(cocientes);
        cociente=(double)1/cocientes[i-1];
        for(int j=i-2;j>=0;j--){
            cociente=(double)cocientes[j]+cociente;
            if(j>0){
                cociente=(double)1/cociente;
            }
        }
        return cociente;
    }

}
