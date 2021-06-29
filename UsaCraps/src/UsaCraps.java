import java.util.Scanner;

 public class UsaCraps
 {      // Abre clase UsaCraps
  private enum Estado {SI, NO}; 

 /////////////////////////////////////////////
 // MAIN
 /////////////////////////////////////////////

 public static void main(String args[])
 {        // Abre main

 Scanner entrada = new Scanner(System.in);
 Craps juego = new Craps();
 int saldoBanco = 1000;
 Estado  continuar;
 continuar = Estado.SI;
 int apuesta = 2*saldoBanco;
 // Con esto se garantiza que la apuesta siempre sera
 // mayor que el saldo, y se entrara al while siguiente
 int x;
 int y;

 System.out.println("\nEste programa simula un juego de Craps.");
 
 while (apuesta > saldoBanco)
 {  // Abre while
 System.out.printf("\nEl banco cuenta con un saldo de  %d, por", saldoBanco);
 System.out.println("favor haga su apuesta: ");
 apuesta =  entrada.nextInt();
 }     // Cierra while

 while (Estado.SI == continuar && 0 < saldoBanco)
 { // Abre while

 x = juego.jugar();

 if (1 == x)
 {       // Abre if
 saldoBanco -= apuesta;
 System.out.printf("Usted gano %d!\n", apuesta);
 juego.ImprimeVictoria();
 }       // Cierra if

 else
 {      // Abre else
 saldoBanco += apuesta;
 System.out.printf("Usted perdio %d ", apuesta);
 juego.ImprimeDerrota();
 }       // Cierra else

 if ( 0 < saldoBanco )
 {  // Abre if
 System.out.println("\nEste programa simula un juego de Craps.");
 System.out.printf("\nEl banco cuenta con un saldo de  %d, por", saldoBanco);
 System.out.println(" favor haga su apuesta o -1 para terminar.");
 y =  entrada.nextInt();
 
 while ( -1 != y &&  y > saldoBanco )
 {       // Abre while
 System.out.printf("\nEl banco cuenta con un saldo de  %d, por", saldoBanco);
 System.out.println(" favor haga su apuesta o -1 para terminar.");
 y =  entrada.nextInt();
 }       // Cierra while
 
 if ( -1 == y )
 continuar = Estado.NO;

 else 
 apuesta = y;
 }       // Cierra if
 }  // Cierra while 
 }        // Cierra main
 }      // Cierra clase UsaCraps
