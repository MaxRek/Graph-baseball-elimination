/* Marchau Coralie - Rekar Maxime : Projet Graphes II et Réseaux 2022 */
import java.util.ArrayList;
import Entity.Reseau;
import Entity.Equipe;
import java.io.FileNotFoundException;

public class main {  
	public  static  void main (String [] arguments) throws FileNotFoundException{  
		Reseau r = new Reseau("../../Data/ex1.txt");
		
		ArrayList<Equipe> elimines = r.global();
		System.out.println("\n==Coralie Marchau et Maxime REKAR==\n-------Graphes II et Reseaux-------\n======Elimination au baseball======\n");
		if(elimines.size() > 0 ){
			System.out.println("Les equipes perdantes sont : ");
			for(int i = 0 ;i <elimines.size();i++){
				System.out.println("   - "+elimines.get(i).getName());
			}
		} else {
			System.out.println("Aucune équipe n'a enore été eliminé");
		}
		System.out.println("\n");

	
		System.exit(0); 
	}
}