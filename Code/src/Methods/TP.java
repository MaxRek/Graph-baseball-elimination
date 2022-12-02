package Methods;

import Entity.Graphe;

public class TP {
    
    public static Graphe init_Graph(int nbE){
        int nbT = 2+nbE+(nbE-1)+(((nbE-2)*(nbE-1))/2); //nb total de sommets
        int a = 1; //sert pour les matchs entre équipe
        int b = 2;

        Graphe graph = new Graphe(nbT);

        for (int i = 1 ; i<nbT-1 ; i++){ //liés S aux victoires + matchs restants
            graph.addInListSuccesseur(0, i, 0, 1);
            if(i<=nbE){
                graph.addInListSuccesseur(i,nbT-1, 0,1); //liés victoires à T
            } else  { // liés matchs restants au match correspondant
                
                graph.addInListSuccesseur(i, a, 0, 1);
                graph.addInListSuccesseur(i, b, 0, 1);
                
                if(b == nbE){
                    a = a + 1;
                    b = a + 1;
                } else {
                b = b + 1;
                }
            }
        }
        
        return graph;
    }
}
