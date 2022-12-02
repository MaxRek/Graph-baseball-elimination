/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
import Entity.*;
import Entity.ListeSuccesseur.*;
import Methods.TP;

public class main {  
	public  static  void main (String [] arguments) {  
		System.out.println("Bonjour le monde") ;  
		Graphe test = TP.init_Graph(7);
		System.out.println(test);
		System.exit(0) ; 
	}
}