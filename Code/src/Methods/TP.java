package Methods;

import Entity.Graphe;

public class TP {
    
    public static Graphe init_Graph(int[][] data){
        
        int nbE = data.length;
        int nbT = 2+nbE+(nbE-1)+(((nbE-2)*(nbE-1))/2); //nb total de sommets
        int a = 1; //sert pour les matchs entre équipe
        int b = 2;

        Graphe graph = new Graphe(nbT);

        for (int i = 1 ; i<nbT-1 ; i++){ 
            if(i<=nbE){
                //lier S aux victoires
                graph.addInListSuccesseur(0, i, data[i-1][0], data[i-1][0]); 
                //lier victoires à T
                graph.addInListSuccesseur(i,nbT-1, data[i-1][0],(data[i-1][0]+data[i-1][1])); 
            
            } else  { 
                //liés la source aux matchs restants
                graph.addInListSuccesseur(0, i, data[a-1][b+1], data[a-1][b+1]);
                
                // liés matchs restants au match correspondant
                graph.addInListSuccesseur(i, a, 0, data[a-1][b+1]);
                graph.addInListSuccesseur(i, b, 0, data[a-1][b+1]);

                if(b == nbE){
                    a = a + 1;
                    b = a + 1;
                } else {
                b = b + 1;
                }
            }
            System.out.println("a = "+a+" ,b = "+b+" , b+1 = "+(b+1));
        }
        return graph;
    }
}
