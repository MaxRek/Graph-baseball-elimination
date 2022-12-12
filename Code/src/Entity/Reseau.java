package Entity;

import java.util.*;
import Methods.*;
import java.io.FileNotFoundException;


import Entity.Graph.*;
/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
public class Reseau { 
private Equipe equipes[];
private int[][] data;
private int nbEquipes;

/* Constructeur Reseau: Complexité =  O() */
public Reseau(String nomFichier) throws FileNotFoundException{
  Parser p = new Parser(nomFichier);
  this.equipes = p.equipes;
  this.nbEquipes = p.nbEquipe;
  this.data = new int[nbEquipes][nbEquipes];
  for (int i=0; i<this.nbEquipes; i++){
    this.data[i][0]= equipes[i].getWin();
    this.data[i][1]= equipes[i].getmatchRestants();
    for (int j=0; j<this.nbEquipes-1; j++){
        this.data[i][2+j] = equipes[i].getmatchsContre(j);
    }
  }
}

/* ConstructionReseau : Complexité =  */
public GrapheFlots constructionReseau(int i){
  return TP.init_Graph(data, i);
}

/* ConstructionReseau : Complexité =  */
public int dichoElimination(){
  int deb = 0;
  int end = this.nbEquipes - 1;
  int milieu = end/2;
  Boolean continuing = true;
  int trouve = 0;
  while(continuing){
    if(testEliminationEquipe(milieu)){
      trouve = milieu;
      deb = milieu;
      milieu = deb + (end-deb)/2;
    } else {
      if((trouve>milieu && trouve>0)||(deb<end && trouve==0)){
        end = milieu;
        milieu = deb + (end-deb)/2;
      } else {
        continuing = false;
      }
    }
  }
  return trouve;
}

/* TestEliminationEquipe : Complexité =  */
public Boolean testEliminationEquipe(int elimine){
  GrapheFlots G = constructionReseau(elimine);
  return G.fordFulkerson();
}

/* TestEliminationToutes : Complexité =  */
public Equipe[][] testEliminationToutes(int elimine){
  Equipe equipesEliminees[] = new Equipe[elimine];
  Equipe equipesEnLice[] = new Equipe[this.nbEquipes - elimine];
  for(int i=0; i<this.nbEquipes; i++){
    if(i<=elimine){equipesEliminees[i] = this.equipes[0];}
    else{equipesEnLice[i] = this.equipes[0];}
  }
  Equipe resume[][] = {equipesEliminees, equipesEnLice};
  return resume;
}

/* global : Complexité =  */
public Equipe[][] global(){
  Arrays.sort(this.equipes, new Comparator<Equipe>() {
    public int compare(Equipe one,Equipe other) {
    int scorePotentiel = one.getmatchRestants() + one.getWin();
    int scorePotentielOther = other.getmatchRestants() + other.getWin();
    return scorePotentiel-scorePotentielOther;
  }
  });
  int elimine = dichoElimination();
  if (elimine>0){
    return testEliminationToutes(elimine);
  } else {
    Equipe resume[][] = { null , this.equipes};
    return resume;
  }
}

}