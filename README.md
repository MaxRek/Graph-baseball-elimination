# Graphe II elimination au baseball

Maxime REKAR et Coralie MARCHAU

Pour compiler, placer vous dans Code\src, puis éxécutez cette commande : 

    javac main.java -d ..\bin

Pour éxécutez, placer vous dans Code\bin, puis éxécutez cette commande :

    java main

## Problème :
Aux Etats-Unis, pendant une saison de baseball, le but de toutes les équipes est de gagner leur division pour ainsi se
qualifier aux barrages. Pour cela, l’équipe qualifiée aura gagner plus de matchs que toutes les autres de sa division.
A la fin des matchs inter-divisions, on peut facilement voir la (ou les) gagnante(s), il est plus difficile de le prévoir
avant au premier coup d’oeil. De par l’utilisation de graphes de flots, nous allons faire un programme permettant
en tout temps de la saison de voir les équipes éliminées et celles encore en lice.

Prenons l'exemple dans "Data/ex1.txt"

Equipe____________Score___NbJeuxRestants__NY__Bos_Tor_Bal

New York Yankees___93___________8_________-___1___6___1

Boston Red Sox______89___________4_________1___-___0___3

Toronto Blue Jays____88___________7_________6___0___-___1

Baltimore Orioles____86___________5_________1___3___1___-

Pour savoir si l’équipe i (dans l’exemple suivant, nous choisissons l’équipe 3 : les Torontos Blue Jays) est toujours
en lice, nous faisons un graphe de flot de la forme suivante. De la source, on lie des sommets correspondants aux
matchs entre deux équipes (pas de sommets pour les matchs avec l’équipe dont on cherche l’état), leur capacité
étant le nombre de fois que ce match doit arriver (dans l’exemple, les Boston Red Sox et Baltimores Orioles ont 3
matchs ensembles, l’arc vers le sommet 2-4 a donc comme capacité 3). Les sommets de matchs sont liés à chacune
des équipes du match. Ces équipes (disons j) sont liés au puits avec une capacité de wi + ri − wj . (Par exemple :
l’arc 2-t a une capacité de 95 - 89 soit 6)

## Résolution
Pour vérifier si une équipe n'est pas éliminée, nous considérons l'usage de Ford Fulkerson pour construire un réseau avec un flot maximum. 
Le but est de vérifier apres construction si la liste de succeseur de la source est vide. 
Si elle l'est, celà veut dire que l'équipe est capable de se placer en première place de la ligue, car il existe un réseau où le résultat 
inter-autres équipes peut amener l'équipe vérifié à être première de la ligue.
Si elle n'est pas vide, celà veut dire que des matchs inter-autres équipes placeront forcément une équipe au delà du score 
maximum possible pour l'équipe vérifiée.
