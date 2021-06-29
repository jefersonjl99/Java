/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jefer
 */

public class Piezas
{
    //Definicion variables
    Coordinates posicionRey = new Coordinates(1,1);
    Coordinates posicionCaballo = new Coordinates(1,1);
    Coordinates posicionReina = new Coordinates(1,1);
    Coordinates posicionReyB = new Coordinates(1,1);


    int [][]ataque=new int [12][12];
    int [][]fichas=new int [12][12];



    //Cnstructor
    Piezas()
    {
    }//fin Constructor



    //Metodo inicializar matriz
    void inicializar()
    {
        int i,j;
        for(i=0; i<12; i++)
        {
            for(j=0; j<12; j++)
            {
                fichas[i][j]=0;
                if( (i==0 ||i==1 ||i==10||i==11)||
                        (j==0 ||j==1 ||j==10||j==11))
                {
                    ataque[i][j]=1;
                }
                else
                {
                    ataque[i][j]=0;

                }
            }
        }
    }//fin Metodo inicializar matriz



    //POSICION EN LA MATRIZ REY NEGRO
    void m_rey_negro(Coordinates r)
    {
        for(int i=0; i<12; i++)
        {
            for(int j=0; j<12; j++)
            {
                if(fichas[i][j]==11)
                {
                    fichas[i][j]=0;
                }
            }
        }
        for(int i=r.x-1; i<r.x+2; i++)
        {
            for(int j=r.y-1; j<r.y+2; j++)
            {
                ataque[i][j]=1;
            }
        }

        ataque[r.x][r.y]=11;
        fichas[r.x][r.y]=11;
    }//fin POSICION EN LA MATRIZ REY NEGRO



    //POSICION EN LA MATRIZ CABALLO NEGRO
    void m_caballo_negro(Coordinates r)
    {
        for(int i=0; i<12; i++)
        {
            for(int j=0; j<12; j++)
            {
                if(fichas[i][j]==14)
                {
                    fichas[i][j]=0;
                }
            }
        }
        ataque[r.x+2][r.y+1]=1;
        ataque[r.x+2][r.y-1]=1;
        ataque[r.x+1][r.y-2]=1;
        ataque[r.x+1][r.y+2]=1;
        ataque[r.x-2][r.y+1]=1;
        ataque[r.x-2][r.y-1]=1;
        ataque[r.x-1][r.y+2]=1;
        ataque[r.x-1][r.y-2]=1;
        ataque[r.x][r.y]=14;
        fichas[r.x][r.y]=14;
    }//fin POSICION EN LA MATRIZ CABALLO NEGRO



    //POSICION EN LA MATRIZ REY BLANCO
    void m_reina_negra(Coordinates r)
    {
        for(int i=0; i<12; i++)
        {
            for(int j=0; j<12; j++)
            {
                if(fichas[i][j]==12)
                {
                    fichas[i][j]=0;
                }
            }
        }
        double m0=r.y-r.x;
        double m1=r.y+r.x;

        for (int i=0; i<12; i++)
        {
            for (int j=0; j<12; j++)
            {
                ataque[r.x][j]=1;
                ataque[i][r.y]=1;

                if(j==i+m0)
                {
                    ataque[i][j]=1;
                }
                if(j==-i+m1)
                {
                    ataque[i][j]=1;
                }
            }
        }

        ataque[r.x][r.y]=12;
        fichas[r.x][r.y]=12;
    }//fin POSICION EN LA MATRIZ REINA NEGRA



    //POSICION EN LA MATRIZ REY BLANCO
    void m_rey_blanco(Coordinates r)
    {
        for(int i=0; i<12; i++)
        {
            for(int j=0; j<12; j++)
            {
                if(fichas[i][j]==21||fichas[i][j]==31)
                {
                    fichas[i][j]=0;
                }
            }
        }
        if(ataque[r.x][r.y]==1)
        {
            ataque[r.x][r.y]=31;
        }
        else
        {
            ataque[r.x][r.y]=21;
        }
        fichas[r.x][r.y]=21;
    }//fin POSICION EN LA MATRIZ REY BLANCO



    //ESTADO DEL REY BLANCO
    String estado_rey_blanco(Coordinates r)
    {
        if(jaque_mate(r.x,r.y)==1)
        {
            System.out.println("JAQUE MATE");
            return "Jaque Mate";
        }
        else if(ahogado(r.x,r.y)==1)
        {
            System.out.println("Ahogado");
            return "Ahogado";
        }
        else if(jaque(r.x,r.y)==1)
        {
            System.out.println("JAQUE");
            return "Jaque";
        }
        else if(libre(r.x,r.y)==1)
        {
            System.out.println("Libre");
            return "Libre";
        }

        return "no hay datos del rey blanco o son erroneos";
    }//fin ESTADO DEL REY BLANCO



    //JAQUE MATE
    int jaque_mate(int x,int y)
    {
        if(x>=2&&y>=2&&x<10&&y<10)
        {
            int tot=0;
            if(ataque[x][y]==31||ataque[x][y]==1)
            {
                for(int i=x-1; i<=x+1; i++)
                {
                    for(int j=y-1; j<=y+1; j++)
                    {
                        if(i==x && j==y)
                        {
                            continue;
                        }
                        if(ataque[i][j]==1)
                        {
                            tot+=1;
                        }
                    }
                }
                if(tot==8)
                {
                    return 1;
                }
            }
        }
        return 0;

    }//fin JAQUE MATE



    //Metodo AHOGADO
    int ahogado(int x,int y)
    {
        int i,j;
        int tot=0;
        if(ataque[x][y]==21)
        {
            for(i=x-1; i<=x+1; i++)
            {
                for(j=y-1; j<=y+1; j++)
                {
                    if(i==x && j==y)
                    {
                        continue;
                    }
                    if(ataque[i][j]==1)
                    {
                        tot+=1;
                    }
                }
            }
            if(tot==8)
            {
                return 1;
            }
        }
        return 0;
    }//fin Metodo AHOGADO



    //Metodo LIBRE
    int libre(int x,int y)
    {
        int i,j;
        int tot=0;
        if(ataque[x][y]==21)
        {
            for(i=x-1; i<=x+1; i++)
            {
                for(j=y-1; j<=y+1; j++)
                {
                    if(i==x && j==y)
                    {
                        continue;
                    }
                    if(ataque[i][j]==1)
                    {
                        tot+=1;
                    }

                }
            }
            if(tot<8)
            {
                return 1;
            }
        }
        return 0;
    }//fin Metodo LIBRE



    //Metodo JAQUE
    int jaque(int x,int y)
    {
        if(x>=2&&y>=2&&x<10&&y<10)
        {
            int i,j;
            int tot=0;
            if(ataque[x][y]==31||ataque[x][y]==1)
            {
                for(i=x-1; i<=x+1; i++)
                {
                    for(j=y-1; j<=y+1; j++)
                    {
                        if(i==x && j==y)
                        {
                            continue;
                        }
                        if(ataque[i][j]==1)
                        {
                            tot+=1;
                        }
                    }
                }
                if(tot<8)
                {
                    return 1;
                }
            }
        }
        return 0;
    }//fin Metodo JAQUE



    //Metodo Imprimir matriz
    int[][] m_imprima()
    {

        System.out.printf("%3d ", 0);
        for (int i=0; i<12; i++)
        {
            System.out.printf("%3d ", i);
        }
        System.out.println();
        for (int i=0; i<12; i++)
        {
            System.out.printf("%3d ", i);
            for (int j=0; j<12; j++)
            {
                System.out.printf("%3d ", ataque[i][j]);
            }
            System.out.println("");
        }

        return ataque;
    }//fin Metodo Imprimir matriz


    int[][] obtener_fichas()
    {
        System.out.printf("%3d ", 0);
        for (int i=0; i<12; i++)
        {
            System.out.printf("%3d ", i);
        }
        System.out.println();
        for (int i=0; i<12; i++)
        {
            System.out.printf("%3d ", i);
            for (int j=0; j<12; j++)
            {
                System.out.printf("%3d ", fichas[i][j]);
            }
            System.out.println("");
        }

        return fichas;
    }
}//fin Clase

/*
vacio=0
atacado=1
rey negro=11
reina negro=12
alfil negro=13
caballo negro=14
torre negro=15
peon negro=16
rey blanco=21
reina blanco=22
alfil blanco=23
caballo blanco=24
torre blanco=25
peon blanco=26

*/
