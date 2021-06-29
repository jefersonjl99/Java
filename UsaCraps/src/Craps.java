import java.util.Random;
 
 public class Craps
 {               // Abre la clase publica Craps
 
 // Crea un generador de numeros aleatorios
 // para usarlo en el metodo TirarDado
 private Random numerosAleatorios = new Random();

 // enumeracion con constantes que representan el estado
 // del juego
 private enum Estado {CONTINUA, GANO, PERDIO}; 

 //constantes que representan tiros comunes del dado
 private final static int DOS_UNOS = 2;
 private final static int TRES = 3;
 private final static int SIETE = 7;
 private final static int ONCE = 11;
 private final static int DOCE = 12;

 ////////////////////////////////////////
 // Metodo Jugar
 ////////////////////////////////////////

 // Ejecutar un juego de Craps
 public int jugar()
 {   // Abre metodo jugar
 
 int miPunto = 0;
 // punto si no gana o pierde en el primer tiro
 Estado estadoJuego;
 // Puede contener CONTINUA, GANA O PERDIO;

 int sumaDeDados = tirarDados();
 // primer tiro de los dados
 
 // determina el estado del juego y el punto
 // en base en el primer tiro
 switch( sumaDeDados )
 {        // Abre switch
 case SIETE: // gana con 7 en el primer tiro
 case ONCE: // gana con once en el primer tiro
 estadoJuego = Estado.GANO;
 break;
 
 case DOS_UNOS: //Pierde con 2 en el primer tiro
 case TRES: //Pierde con 3 en el primer tiro
 case DOCE: // Pierde con 12 en el primer tiro
 estadoJuego = Estado.PERDIO;
 break;
 
 default: // No gano ni perdio, por lo que guarda el punto
 estadoJuego = Estado.CONTINUA; // No ha terminado el juego
 miPunto = sumaDeDados; // guarda el punto
 System.out.printf("El punto es %d\n", miPunto);
 break; // opcional al final del switch

 }        // Cierra switch
 // mientras el juego no este terminado
 while( estadoJuego == Estado.CONTINUA )
 {  // Abre while
 sumaDeDados = tirarDados();
 // determina el estado del juego
 if (sumaDeDados == miPunto)
 estadoJuego = Estado.GANO;
 else
 if (sumaDeDados == SIETE )
 estadoJuego = Estado.PERDIO;

 }   // Cierra while

 //muestra mensaje de que gano o perdio
 if ( estadoJuego == Estado.GANO )
 {  // Abre if
 System.out.println("El jugador gana");
 return 1;
 }    // Cierra if
 else
 {  // Abre else 
 System.out.println("El jugador pierde");
 return -1;
 }      // Cierra else
 }  // Cierra metod jugar

 // tira los dados, calcula la suma
 // y muestra los resultados
 
 public int tirarDados()
 {           // Abre metodo tirarDados
 // elige valores aleatorios para los dados
 int dado1 = 1 + numerosAleatorios.nextInt(6);
 int dado2 = 1 + numerosAleatorios.nextInt(6);
 int suma = dado1 + dado2;
 
 // muestra los resultados de ese tiro
 System.out.printf("El jugador tiro %d + %d = %d\n",
 dado1, dado2, suma);

 return suma;
 }          // Cierra metodo tirarDados

 /////////////////////////////////////////
 // ImprimeDerrota
 /////////////////////////////////////////

 public void ImprimeDerrota()
 {  // Abre metodo ImprimeDerrota
 int  auxiliar = 1 + numerosAleatorios.nextInt( 5 );
 
 switch (auxiliar)
 {  // Abre switch
 case 1:
 System.out.println("\nLo siento. Siga intentando!");
 break;
 case 2:
 System.out.println("\nSi no vuelve a jugar, no se recuperara");
 break;
 case 3:
 System.out.println("\nPronto cambiara su suerte!");
 break;
 case 4:
 System.out.println("\nOh, se esta yendo a la quiebra, verdad?");
 break;
 case 5:
 System.out.println("\nMejor retirese y conserve algo de su dinero!");
 break;
 default:
 System.out.println("\nRevise este metodo!");
 break;
 }        // Cierra switch

 }      // Cierra metodo ImprimeDerrota

 /////////////////////////////////////////
 // ImprimeVictoria
 /////////////////////////////////////////

 public void ImprimeVictoria()
 {  // Abre metodo ImprimeVictoria
 int  auxiliar = 1 + numerosAleatorios.nextInt( 5 );
 
 switch (auxiliar)
 {  // Abre switch
 case 1:
 System.out.println("\nFelicidades!");
 break;
 case 2:
 System.out.println("\nEsta usted acabando con la banca!");
 break;
 case 3:
 System.out.println("\nEsto es una buena racha!");
 break;
 case 4:
 System.out.println("\nHoy es su dia de suerte, verdad?");
 break;
 case 5:
 System.out.println("\nYa puede cambiar sus fichas por mucho dinero!");
 break;
 default:
 System.out.println("\nRevise este metodo!");
 break;
 }        // Cierra switch
 }       // Cierra metod ImprimeVictoria
 }               // Cierra la clase publica Craps

//