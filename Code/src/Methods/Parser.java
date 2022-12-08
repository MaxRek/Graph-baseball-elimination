package Methods;

import Entity.Equipe;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Parser{
    public Equipe equipes[];

    public Parser(String nameFile)throws FileNotFoundException{
       FileReader file = new  FileReader(nameFile);         
      Scanner scanner = new Scanner(file);  
      int nbEquipe = Integer.parseInt(scanner.nextLine());
      equipes = new Equipe[nbEquipe];
      String team[] = new String[nbEquipe + 3];
      int i = 0;
      int tabGame[] = new int[nbEquipe];
      while(scanner.hasNextLine())
      {
        team = scanner.nextLine().split(" ");
        tabGame = Arrays.stream(Arrays.copyOfRange(team, 4, 4+nbEquipe)).mapToInt(Integer::parseInt).toArray();
        equipes[i] = new Equipe(team[1],Integer.parseInt(team[2]),Integer.parseInt(team[3]), tabGame);
        i = i + 1;
      }
    scanner.close();
  }
}
