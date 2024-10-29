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
private int[] sortedEquipes;

/* Constructeur Reseau: Complexité =  O() */
public Reseau(String nomFichier) throws FileNotFoundException{
  Parser p = new Parser(nomFichier);

  this.equipes = p.equipes;
  this.nbEquipes = p.nbEquipe;
  this.data = new int[nbEquipes][nbEquipes+2];
  this.sortedEquipes = new int[nbEquipes];
  for (int i=0; i<this.nbEquipes; i++){
    this.data[i][0]= equipes[i].getWin();
    this.data[i][1]= equipes[i].getmatchRestants();
    for (int j=0; j<this.nbEquipes; j++){
      this.data[i][2+j] = equipes[i].getmatchsContre(j);
    }
  }
  
}

/* ConstructionReseau : Complexité =  */
public GrapheFlots constructionReseau(int i){
  //Tools.printMatrixArray(data);
  return TP.init_Graph(data, i);
}

/* ConstructionReseau : Complexité =  */
public int dichoElimination(){
  int deb = 0;
  int end = this.nbEquipes - 1;
  int milieu = Math.round(end/2);
  Boolean continuing = true;
  int trouve = end;
  while(continuing){
    // System.out.println("equipe[milieu] = "+ this.equipes[milieu]);
    // System.out.println("deb = "+deb+" ,end = "+end+" ,trouve = "+trouve+ " ,milieu = "+milieu+" ,elimine = "+testEliminationEquipe(milieu)+"\n=============================");
      if((milieu==deb)||( milieu==end )){
        continuing=false;
      } else {
        if(!testEliminationEquipe(this.sortedEquipes[milieu])){
          deb = milieu;
        } else {
          end = milieu;
          if(milieu<trouve){
            trouve = milieu;
          }
        }
      }
      milieu = deb + Math.round((end-deb)/2);
    }
  // System.out.println("deb = "+deb+" ,end = "+end+" ,trouve = "+trouve+ " ,milieu = "+milieu+" ,elimine = "+testEliminationEquipe(milieu));
  return trouve-1;
}

/* TestEliminationEquipe : Complexité =  */
public Boolean testEliminationEquipe(int elimine){
  return constructionReseau(elimine).test();
}

/* TestEliminationToutes : Complexité =  */
public ArrayList<Equipe> testEliminationToutes(int elimine){
  ArrayList<Equipe> elimines = new ArrayList<Equipe>();
  for(int i=0; i<this.nbEquipes; i++){
    if(i<=elimine){
      elimines.add(this.equipes[this.sortedEquipes[i]]);
    }
  }
  return elimines;
}

/* global : Complexité =  */
public ArrayList<Equipe> global(){
  Equipe[] equipeS = this.equipes.clone();
  Arrays.sort(equipeS, new Comparator<Equipe>() {
    public int compare(Equipe one,Equipe other) {
    int scorePotentiel = one.getmatchRestants() + one.getWin();
    int scorePotentielOther = other.getmatchRestants() + other.getWin();
    return scorePotentiel-scorePotentielOther;
    }
  });

  for(int i = 0; i<this.equipes.length;i++){
    for(int j = 0; j<this.equipes.length; j++){
      if(this.equipes[j].getName()==equipeS[i].getName()){
        this.sortedEquipes[i]=j;
      }
    }
  }

  //Tools.printIntArray(this.sortedEquipes);

  int elimine = dichoElimination();
  return testEliminationToutes(elimine);
}

}