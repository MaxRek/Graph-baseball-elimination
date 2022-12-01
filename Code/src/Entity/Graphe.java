package Entity;

import java.lang.reflect.Array;
import java.util.LinkedList;

import Entity.ListeSuccesseur.*;

/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
public class Graphe {
    
    private ListeSuccesseur listSuccesseur[];

    // public Graphe(int nbS){
    //     this.listSuccesseur = new ListeSuccesseur[];
    // }

    /* Construction : Complexité =  */
    public Graphe(int nbS){
        this.listSuccesseur = new ListeSuccesseur[nbS];
        for(int i = 0; i < nbS ; i++){
            this.listSuccesseur[i] = new ListeSuccesseur();
        }
    }

    /* FordFulkerson : Complexité =  */
    public void fordFulkerson(){

    }

    public void addInListSuccesseur (int i, int s, Arc a){
        this.listSuccesseur[i].addSuccesseur(new Successeur(s,a));
    }

    public void delInListSuccesseur (int i, int s){
        this.listSuccesseur[i].delSuccesseur(s);
    }

    public String toString(){
        String str = "Graphe";
        for(int i = 0; i < this.listSuccesseur.length ; i++){
            str = str + "\n Sommet "+i+" : " + this.listSuccesseur[i].toString();
        } 
        return str;
    }
}