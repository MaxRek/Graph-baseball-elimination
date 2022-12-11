package Entity;

import java.util.Scanner;
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

}