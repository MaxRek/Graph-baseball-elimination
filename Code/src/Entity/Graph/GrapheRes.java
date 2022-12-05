package Entity.Graph;

import Entity.ListeSuccesseur.*;


public class GrapheRes extends Graphe{
    
    public GrapheRes(int nbS){
        super(nbS);
    }
    
    public void init_GraphRes (ListeSuccesseur[] listFlots){
        
        for(int i = 0; i< this.listSuccesseur.length; i++){
            ListeSuccesseur ls = listFlots[i];
            if(ls.getSuccesseur() != null){
                Successeur s = ls.getSuccesseur();
                Boolean end = false;
    
                while(!end){
                    int c = s.getArc().getCapacite();
                    int f = s.getArc().getFlot();
                    int sv = s.getName();
                    //vérifier si l'arc est saturé, si oui on crée uniquement du côté du successeur
                    if(c==f){
                        this.addInListSuccesseur(sv, i, f, c);
                    } else if (f==0){ //il faut créer un seul arc, tel que dans le graph de flots
                        this.addInListSuccesseur(i, sv, f, c);
                    } else { //f != c, il faut créer deux arcs
                        this.addInListSuccesseur(i, sv, c-f, c);
                        this.addInListSuccesseur(sv, i, f, c);
                    }

                    //passage au successeur suivant
                    if (s.getSuivant()==null) {
                        end = true;
                    } else {
                        s = s.getSuivant();
                    }
                }
            }    
        }
    }
    public ListeSuccesseur[] getListSuccesseur(){
        return this.listSuccesseur;
    }

    public String toString(){
        return super.toString();
    }
}
