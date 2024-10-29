package Entity.Graph;

import java.util.ArrayList;
import java.util.List;

import javax.swing.border.EmptyBorder;

import Entity.ListeSuccesseur.*;
import Methods.Tools;


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
                    //System.out.println(("c = "+c+", f = "+f+" ,sv = "+sv));
                    
                    //vérifier si l'arc existe (c > 0), si oui on crée uniquement du côté du successeur
                    if(c > 0)
                    {
                        if(c==f){
                            this.addInListSuccesseur(sv, i, f, c);
                        } else if (f==0){ //il faut créer un seul arc, tel que dans le graph de flots
                            this.addInListSuccesseur(i, sv, f, c);
                        } else { //f != c, il faut créer deux arcs
                            this.addInListSuccesseur(i, sv, c-f, c);
                            this.addInListSuccesseur(sv, i, f, c);
                        }  
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

    public ArrayList<Integer> findPath(){
        // retour : une liste d'entier
        ArrayList<Integer> path = new ArrayList<Integer>();
        //liste de sommets déjà exploré, dont on sait qu'on ne peut explorer plus loin
        ArrayList<Integer> explored = new ArrayList<Integer>();
        Boolean stop = false; Boolean trouve = false; 
        
        //ajout de la source
        path.add(0);
        explored.add(0);
        // Debut de la boucle d'exploration
        // System.out.println(listSuccesseur.length);
        // System.out.println(listSuccesseur[listSuccesseur.length-1]);

        while(!stop && !trouve){
            // System.out.println("==============================\nDans premiere boucle\n==============================");
            // System.out.println("path = "+path);
            // System.out.print("explored = " + explored+"\n");
            // System.out.println("sortie = "+ (this.listSuccesseur.length-1));

            if(path.size()==0){
                // System.out.println("pas trouve, stop de boucle");
                stop = true;
            } else if (path.get( path.size()-1 ) == this.listSuccesseur.length-1){
                trouve = true;
                // System.out.println("trouve = " + trouve);
            } else {
                if ( (this.listSuccesseur[ path.get( path.size()-1 ) ]) != null && !trouve){
                    Boolean stop2 = false;
                    Successeur s = (this.listSuccesseur[ path.get( path.size()-1 ) ].getSuccesseur());
                    //Exploration de chaque successeur, on ajoute le premier qu'on trouve qui n'ait pas déjà été exploré
                    while(!stop2 && !trouve){
                        // System.out.println("--------------------------\nDans seconde boucle\n--------------------------");
                        // System.out.println("     s = "+s);
                        if(s != null){
                            // if(s.getSuivant() != null){
                            //     System.out.println(" il y a un suivant "+s.getSuivant().getName());
                            // } else {
                            //     System.out.println(" il n'y a pas de suivant ");
                            // }
                            if( !explored.contains( s.getName() ) ){
                                path.add(s.getName());
                                explored.add(s.getName());
                                stop2 = true;
                            }else{
                                if(s.getSuivant() != null){
                                    s = s.getSuivant();

                                } else {
                                    stop2 = true;
                                    path.remove(path.size()-1);
                                }
                            }
                        } else {
                            stop2 = true;
                            path.remove(path.size()-1);
                        }
                       
                    }
                } else {
                    path.remove(path.size()-1);
                }
            }
        }
        return path;
    }

    public int getMaxPossibleFlot (ArrayList<Integer> lA){
        int min = 10000; //Selon le cas donné, les problèmes ne dépasseront jamais la centaine de matchs, dont on se permet une facilité d'écriture
        //System.out.println(min);
        for(int i = 0 ; i<lA.size()-1; i++){
            Boolean stop = false;
            Successeur s = this.listSuccesseur[lA.get(i)].getSuccesseur();
            while(!stop){ 
                if(s.getName() != lA.get((i+1))){
                    s = s.getSuivant();
                } else {
                    if(min > s.getArc().getFlotRestant()){
                        min = s.getArc().getFlotRestant();
                       // System.out.println( "r = " + s.getArc().getResiduel() + " ,c = " + s.getArc().getCapacite() + " , f = "+ s.getArc().getFlot() + " ,min = " +min);
                    }
                    stop = true;
                }
            }
        }
        return min;
    }
    public void addFlot(ArrayList<Integer> lA, int f){
        for(int i = 0 ; i<lA.size()-1; i++){
            //System.out.println("lA(i) = "+lA.get(i)+"lA(i+1) = "+lA.get(i+1)+" f = "+f);
            addFlotArc(lA.get(i),lA.get(i+1), f);
        }
    }

    //sb = sommet base ; se = sommet end ; f = flot à ajouter
    public void addFlotArc(int sb, int se, int f){
        Boolean stop = false;
        Successeur s = listSuccesseur[sb].getSuccesseur();
        //System.out.println("               sb = " + sb + " se = " + se + " f = " +f);
        while(!stop){ 
            if(s.getName() != se){ //si le successeur n'est pas le bon, on avance au suivant. On sait que le successeur correspondant existe
                s = s.getSuivant();
            } else { //on a trouvé le bon successeur
                if(s.getArc().getFlotRestant() >= f){ //s'il est spossible de correctement augmenté le flot
                    if(s.getArc().getCapacite()== f+s.getArc().getFlot()){ //si on a saturé l'arc, on le supprime
                        if(!s.getArc().getResiduel()){//il ne s'agissait pas d'un arc résiduel
                            listSuccesseur[se].updateFlotSuccesseur(sb,s.getArc().getCapacite(), s.getArc().getCapacite(),true);;    
                            listSuccesseur[sb].delSuccesseur(se);
                        } else {//il s'agissait  d'un arc résiduel
                            listSuccesseur[se].updateFlotSuccesseur(sb,s.getArc().getCapacite(), s.getArc().getCapacite(),false);;    
                            listSuccesseur[sb].delSuccesseur(se);
                        }
            
                    } else { // l'arc n'est pas saturé, on update les deux côtés
                        if(!s.getArc().getResiduel()){ //il ne s'agissait pas d'un arc résiduel
                            s.getArc().setFlot(f+s.getArc().getFlot());
                            listSuccesseur[se].updateFlotSuccesseur(sb,s.getArc().getFlot(), s.getArc().getCapacite(),true);;    
                        }else { //il s'agissait d'un arc résiduel
                            s.getArc().setFlot(f+s.getArc().getFlot());
                            listSuccesseur[se].updateFlotSuccesseur(sb,f+s.getArc().getFlot(), s.getArc().getCapacite(),false);;    
                        }
                    }
                }
                stop = true;
            }
        }
    }

    public String toString(){
        String str = "Graphe residuel";
        for(int i = 0; i < this.listSuccesseur.length ; i++){
            str = str + "\n Sommet "+i+" : " + this.listSuccesseur[i].toString();
        } 
        return str;
    }
}
