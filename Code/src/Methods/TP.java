package Methods;

import Entity.Graph.*;

public class TP {

    public static GrapheFlots init_Graph(int[][] dataAll, int e){

        int sp = dataAll[e][0] + dataAll[e][1]; //score potentielle de l'équipe (victoires actuelles + matchs restants)
        int[][] data = Tools.copyMatrixWithoutTeam(dataAll,e);
        int nbE = data.length;
        int nbT = 2+nbE+(nbE-1)+(((nbE-2)*(nbE-1))/2); //nb total de sommets
        // System.out.println("Truc , nbE = " + nbE+ " ,nbT = " + nbT);

        int a = 1; //sert pour les matchs entre équipe
        int b = 2;
        
        GrapheFlots graph = new GrapheFlots(nbT);

        for (int i = 1 ; i<nbT-1 ; i++){ 
            if(i<=nbE){
                //lier victoires à T
                if(sp - data[i-1][0]>0){
                    graph.addInListSuccesseur(i,nbT-1, 0,(sp - data[i-1][0])); 
                }

            } else  { 
                //liés la source aux matchs restants
                graph.addInListSuccesseur(0, i, 0, data[a-1][b+1]);
                
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
