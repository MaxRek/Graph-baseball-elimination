package Entity.ListeSuccesseur;

/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
public class Arc { 
  
  private int capacite;
  private int flot;
  private int connecteA;

  /* Constructeurs arc : Complexité = O(1) */
  public Arc(int c, int a){
    this.capacite = c;
    this.flot = 0;
    this.connecteA = a;
  }

  /* getters et setters : Complexité = O(1) */
  public void setFlot(int x){
    if(x<=this.capacite){
      this.flot += x;
    } else {
      System.out.println("Impossible de mettre un flot "+x+" vers "+connecteA+" supérieur à la capacité "+capacite);
    }
  }

  public void setCapacite(int x){
    this.capacite = x;
  }
  
  public int getCapacite(){
    return this.capacite;
  }

  public int getFlot(int x){
    return this.flot;
  }

  public String toString(){
    return "(Capacite : "+this.capacite+" , flot : "+this.flot+" ,connecte : "+this.connecteA+")";
  }
}