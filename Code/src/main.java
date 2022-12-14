/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
import java.lang.reflect.Array;

import Entity.Graph.Graphe;
import Entity.Graph.GrapheFlots;
import Methods.TP;
import Methods.Tools;
import Entity.*;
import Entity.ListeSuccesseur.*;
import Methods.*;
import java.io.IOException;
import java.io.FileNotFoundException;

public class main {  
	public  static  void main (String [] arguments) throws FileNotFoundException{  
      Parser p = new Parser("../Data/exemple.txt");
		System.out.println(p.equipes[0].getmatchRestants());
		int[][] data = 
		{
			{93,8,-1,1,6,1},
			{89,4,1,-1,0,3},
			{88,7,6,0,-1,1},
			{86,5,1,3,1,-1}
		};

		for(int i = 0;i<data.length;i++){
			Tools.printIntArray(data[i]);
		}
		System.out.println(data.length);
		int[][] dataM = Tools.copyMatrixWithoutTeam(data, 0);
		for(int i = 0;i<dataM.length;i++){
			Tools.printIntArray(dataM[i]);
		} 
		//GrapheFlots test = TP.init_Graph(data,0);		
		//test.detectErrorFlots();
		//test.init_GraphRes();
		//System.out.println(test);
		//System.out.println(test.getGraphR());
		System.exit(0); 
	}
}