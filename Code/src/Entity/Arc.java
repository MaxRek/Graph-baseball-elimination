package Entity;

/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
public class Arc { 
    private int connecteA;
    private final int capacite;
    private int flot;

    /* Constructeurs arc : Complexité = O(1) */
    public Arc(int c, int f, int a){
      this.capacite = c;
      this.flot = f;
      this.connecteA = a;
    }

    // public Arc(int c){
    //   this.capacite = c;
    //   this.flot = 0;
    //   this.connecteA = a;
    // }

    /* getters et setters : Complexité = O(1) */
    public void setFlot(int x){
      this.flot += x;
    }
    
    public int getFlot(int x){
      return this.flot;
    }
}