/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
import Entity.*;
import Entity.ListeSuccesseur.*;

public class main {  
	public  static  void main (String [] arguments) {  
		System.out.println("Bonjour le monde") ;  
		Graphe test = new Graphe(3);

		System.out.println("Ajout 1") ;  
		test.addInListSuccesseur(1,1,new Arc(8,2));
		System.out.println("Ajout 2") ;  
		test.addInListSuccesseur(1,2, new Arc(7,2));

		// System.out.println("Retirer 1") ;  
		// test.delInListSuccesseur(1,1 );

		System.out.println("Ajout 3") ;  
		test.addInListSuccesseur(1,3, new Arc(10,2));

		System.out.println(test);
		System.exit(0) ; 
	}
}