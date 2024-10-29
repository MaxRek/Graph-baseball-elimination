package Entity.ListeSuccesseur;

/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
public class Arc { 
  
  private int capacite;
  private int flot;
  private boolean residuel; //faux si dans un graphe, vrai dans un résiduel

  /* Constructeurs arc : Complexité = O(1) */
  public Arc(int f, int c){
    this.flot = f;
    this.capacite = c;
    this.residuel = false;
  }
  public Arc(int f, int c, Boolean b){
    this.flot = f;
    this.capacite = c;
    this.residuel = b;
  }

  /* getters et setters : Complexité = O(1) */
  public void setFlot(int f){
    if(f<=this.capacite){
      this.flot = f;
    } else {
      System.out.println("Impossible de mettre un flot "+f+" superieur a la capacite "+capacite + " ; Fin du programme");
      System.exit(1);
    }
  }
  public void setFlotForce(int f){
    this.flot += f;
  }

  public void setCapacite(int x){
    this.capacite = x;
  }
  
  public int getCapacite(){
    return this.capacite;
  }

  public int getFlot(){
    return this.flot;
  }

  public int getFlotRestant(){
    int f = 0;
    if(!this.residuel){
      f = this.capacite - this.flot;
    } else {
      f = this.flot;
    }
    return f;
  }

  public void setResiduel(Boolean b){
    this.residuel = b;
  }

  public Boolean getResiduel(){
    return this.residuel;
  }

  public String toString(){
    String str = "(Flot : "+this.flot+" , Capacite : "+this.capacite;
    if(this.residuel){
      str += " ,residuel";
    }
    return str + ")";
  }
}