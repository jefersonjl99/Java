/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecuaciontercergrado;

/**
 *
 * @author jefer
 */
public class Raices {
    int a,b,c,d;
    double s,raiz,divD[],divA[],PosibleRaiz[];

    Raices(int a, int b, int c,int d) {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }
    
    
    /*public double raiz1(){
        
        //divisores del termino independiente
        for(int i=0;i<=d;i++){
            for(int j=1;j==d;j++){
                if(d%j==0){
                    divD[i]=j;
                }
            }
        }
        //divisores del coeficiente del termino con mayor grado
        for(int i=0;i<=a;i++){
            for(int j=1;j==a;j++){
                if(a%j==0){
                    divA[i]=j;
                }
            }
        }
        //posibles raices
        for(int i=0;i<=a;i++){
            for(int j=0;j==d;j++){
                PosibleRaiz[i]=divD[j]/divA[i];
            }
        }
        for(int i=0;i<=a;i++){
            do{
               s=a*PosibleRaiz[i];
               s=b+s;
               s=s*PosibleRaiz[i];
               s=c+s;
               s=s*PosibleRaiz[i];
               s=d+s;
               raiz=PosibleRaiz[i];
               if(s!=0){
                   s=a*-PosibleRaiz[i];
                   s=b+s;
                   s=s*-PosibleRaiz[i];
                   s=c+s;
                   s=s*-PosibleRaiz[i];
                   s=d+s;
                   raiz=PosibleRaiz[i];
               }
            }while(s!=0);   
        }
        return raiz;
    }*/
    public double raiz2(){
        double discriminante;
        discriminante=Math.pow(b, 2)-(4*a*c);
        return (-b+Math.sqrt(discriminante))/(2*a);
    }
    public double raiz3(){
        double discriminante;
        discriminante=Math.pow(b, 2)-(4*a*c);
        return (-b-Math.sqrt(discriminante))/(2*a);
    }
}
