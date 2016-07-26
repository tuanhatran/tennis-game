# tennis-game kata
Ce projet concernant la simulation du score d'un set de Tennis. La classe d'entree est TennisGame
La base:
Dans le jeu du Tennis, les joueurs commencent avec un score de 0. Avec plusieurs échanges ils gagnent des points et donc gagnent des séquences (jeux).
0 -> 15 -> 30 -> 40
Si un joueur a 40 et marque encore contre son adversaire alors il gagne le jeu tant que l'autre joueur n'a pas lui aussi 40 . Si les deux joueurs ont 40 points alors il y a "deuce".
 
Deuce:
Marquer durant "deuce" donne au joueur avantage . Si l'autre joueur marque aussi alors on retourne "deuce" à nouveau. Si un joueur a avantage et marque après alors ce joueur gagne le jeu.
 
Le score des jeux évolue de la façon suivante :
1 -> 2 -> 3 -> 4 -> 5 -> 6 (-> 7)
Le premier joueur arrivé à 6 jeux gagne le set s’il possède au moins 2 jeux de plus que son adversaire (exemples : 6 - 2, 6 - 4)
Dans le cas d’un score à 6 - 5 , si le joueur 1 marque un jeux alors il gagne le set sur un score the 7 - 5
Dans le cas d’un score à 6 - 6 , les 2 joueurs disputent alors un Tie-break
 
Tie-break :
Les points du tie-break évoluent de la façon suivante : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 …
Le tie-break se termine lorsque le score de l’un des deux joueurs est supérieur à 6 et qu’il a 2 points de plus que son adversaire.
 
Prérequis:
Ecrire un programme qui prend en compte ces éléments pour le tableau des score entre deux joueurs de Tennis.
 
Les joueurs doivent être capable de marquer des points.
Le set doit être fini avec un gagnant.
Le cas "deuce" doit être traité.
Le cas du tie-break en fin de set doit être traité.
Après qu'une partie soit gagnée, le joueur gagnant doit être déterminé.
on doit pouvoir suivre le score de chaque joueurs à tout moment durant la partie.
