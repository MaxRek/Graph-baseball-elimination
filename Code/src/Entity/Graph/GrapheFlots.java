package Entity.Graph;

import Entity.ListeSuccesseur.*;
import Methods.Tools;

public class GrapheFlots extends Graphe{
    
    private int S;
    private int T;
    private GrapheRes graphR;
    //private GrapheRes graphR;

    public GrapheFlots(int nbS){
        super(nbS);
        this.graphR = new GrapheRes(nbS);
        this.S = 0;
        this.T = nbS;
        //this.graphR = null;
    }

    public int [] detectErrorFlots(){

        // va vérifier la contrainte que ensemble flots entrants = ensemble flots sortants
        int[] flotsE = new int[T];
        int[] flotsS = new int[T];
        int[] errors = new int[T+1]; //on ajoute un élement qui va comparer si S = T
        // Parcours des Sucesseurs de chaque sommets, afin d'incrémenter le 
        for(int i = 0; i< T; i++){
            ListeSuccesseur ls = this.getListSuccesseur()[i];
            if(ls.getSuccesseur() != null){
                Successeur s = ls.getSuccesseur();
                Boolean end = false;
    
                while(!end){
                    flotsS[i] += s.getArc().getFlot();
                    flotsE[s.getName()] += s.getArc().getFlot();
                    if (s.getSuivant()==null) {
                        end = true;
                    } else {
                        s = s.getSuivant();
                    }
                }
            }    
        }
        System.out.println("\nFlots Entrants : ");
        Tools.printIntArray(flotsE);
        System.out.println("\nFlots Sortants : ");
        Tools.printIntArray(flotsS);

        for(int i = 0; i< T+1; i++){//Recherche d'érreurs dans les flots, on ignore T qui n'a pas de sortants
            if(i < T){ //traitement de chaque sommets
                if(flotsE[i]>flotsS[i]){
                    errors[i]=1; //les flots entrants sont supérieurs aux flots sortants
                } else if(flotsE[i]<flotsS[i]){
                    errors[i]=2; //les flots sortants sont supérieurs aux flots entrants
                }
            }  
        }
        if(flotsE[T-1]!=flotsS[0]){ // comparer si flotS de S == flotE de T
            errors[T] = 1;
        }
        return errors;
    }

    public void init_GraphRes(){
        this.graphR.init_GraphRes(this.listSuccesseur);
    }

    public GrapheRes getGraphR(){
        return this.graphR;
    }

    public String toString(){
        return super.toString();
    }
    
}