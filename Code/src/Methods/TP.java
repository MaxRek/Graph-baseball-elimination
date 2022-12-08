package Methods;

import Entity.Graph.*;

public class TP {

    public static GrapheFlots init_Graph(int[][] data, int e){
        int nbE = data.length-1;
        int nbT = 2+nbE+(nbE-1)+(((nbE-2)*(nbE-1))/2); //nb total de sommets
        int a = 1; //sert pour les matchs entre équipe
        int b = 2;
        int sp = data[e][0] + data[e][1]; //score potentielle de l'équipe (victoires actuelles + matchs restants)

        GrapheFlots graph = new GrapheFlots(nbT);

        for (int i = 1 ; i<nbT-1 ; i++){ 
            if(i<=nbE){
                //lier victoires à T
                graph.addInListSuccesseur(i,nbT-1, data[i-1][0],(data[i-1][0]+data[i-1][1])); 
            
            } else  { 
                //liés la source aux matchs restants
                graph.addInListSuccesseur(0, i, data[a-1][b+1], data[a-1][b+1]);
                
                // liés matchs restants au à la victoire correspondant
                graph.addInListSuccesseur(i, a, 0, data[a-1][b+1]);
                graph.addInListSuccesseur(i, b, 0, data[a-1][b+1]);

                if(b == nbE){
                    a = a + 1;
                    b = a + 1;
                } else {
                b = b + 1;
                }
            }
            //System.out.println("a = "+a+" ,b = "+b+" , b+1 = "+(b+1));
        }
        return graph; 
    }
}
