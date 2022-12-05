/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
import java.lang.reflect.Array;

import Entity.*;
import Entity.ListeSuccesseur.*;
import Methods.TP;

public class main {  
	public  static  void main (String [] arguments) {  		
		int[][] data = 
		{
			{93,8,-1,1,6,1},
			{89,4,1,-1,0,3},
			{88,7,6,0,-1,1},
			{86,5,1,3,1,-1}
		};
		Graphe test = TP.init_Graph(data);
		System.out.println(test);
		System.exit(0) ; 
	}
}