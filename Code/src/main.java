/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
import java.lang.reflect.Array;

import Entity.Graph.Graphe;
import Entity.Graph.GrapheFlots;
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
		GrapheFlots test = TP.init_Graph(data);		
		test.detectErrorFlots();
		test.init_GraphRes();

		System.out.println(test.getGraphR());
		System.exit(0) ; 
	}
}