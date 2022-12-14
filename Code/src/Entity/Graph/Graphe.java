package Entity.Graph;

import Entity.ListeSuccesseur.*;

/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
public class Graphe {
    
    protected ListeSuccesseur listSuccesseur[];

    /* Construction : Complexité =  */

    /* Construction : Complexité =  */
    public Graphe(int nbS){
        this.listSuccesseur = new ListeSuccesseur[nbS];
        for(int i = 0; i < nbS ; i++){
            this.listSuccesseur[i] = new ListeSuccesseur();
        }
    }

    public ListeSuccesseur[] getListSuccesseur(){
        return this.listSuccesseur;
    }

    public void addInListSuccesseur (int i, int s, int f, int c){
        this.listSuccesseur[i].addSuccesseur(new Successeur(s,new Arc(f, c)));
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