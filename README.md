# A-Star-Search-Algorithm

Description des caractères affichés dans le terminal :</br>
    - ███ : noeud mur. 
    - C : noeud pierre (cobblestone)  
    - S : noeud sable (sand)
    - W : noeud eau (water)
    - STA : noeud de départ
    - END : noeud d'arrivée
    - ≡≡≡ : noeud faisant partie du chemin final
    -  ┼ : noeud ouvert
    -  ╬ : noeud fermé

Guide d'utilisation :
    Au lancement du jar (ou du code) le programme attend un paramètre :
    - 0 : génération aléatoire d'un labyrinthe avec textures aléatoires (attention, aucune garantie qu'il existe un chemin)
    - 1 : génération d'un terrain entièrement vide avec textures aléatoires
    - 2 : génération d'un labyrinthe avec des murs fixée et textures aléatoires

A chaque itération de l'algorithme, pour le labyrinthe classique, vous avez un affichage complet du labyrinthe et ses états, noeuds ouverts et fermés, et le chemin final est affichés sur la dernière itération.
