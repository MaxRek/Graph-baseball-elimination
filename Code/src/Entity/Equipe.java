package Entity;

/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
public class Equipe{
private String name;
private int win;
private int matchRestants;
private int matchsContre[];

/* Constructeur Equipe: Complexité = O(1) */
public Equipe(String name, int win, int matchRestants, int matchsContre[]){
  this.name = name;
  this.win = win;
  this.matchRestants = matchRestants;
  this.matchsContre = matchsContre;
}

/* Constructeur Equipe: vide Complexité = O(1) */
public Equipe(){
  this.name = "Inconnu";
  this.win = 0 ;
  this.matchRestants = 0 ;
  this.matchsContre = 0 ;
}

/* Increment/Decrement : Complexité = O(1) */
public void incrementWin(){
    this.win += 1 ;
}

public void decrementMatchRestants(){
    this.matchRestants += 1 ;
}

public void decrementMatchsContre(int index){
    this.matchsContre[index] += 1 ;
}

/* getters and setters : Complexité = O(1) */
public void setWin(int nbWin){
  this.win = nbWin ;
}

public int getWin(){
  return this.win ;
}

public void setmatchRestants(int nbMatch){
  this.matchRestants = nbMatch ;
}

public int getmatchRestants(){
  return this.matchRestants ;
}

public void setmatchsContre(int index, int nbMatch){
  this.matchsContre[index] = nbMatch;
}

public int getmatchRestants(int index){
  return this.matchsContre[index] ;
}

}