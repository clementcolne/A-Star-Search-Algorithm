# A Star Search Algorithm

Description des caractères affichés dans le terminal :</br>
    - ███ : noeud mur</br>
    - C : noeud pierre (cobblestone)</br>
    - S : noeud sable (sand)</br>
    - W : noeud eau (water)</br>
    - STA : noeud de départ</br>
    - END : noeud d'arrivée</br>
    - ≡≡≡ : noeud faisant partie du chemin final</br>
    -  ┼ : noeud ouvert</br>
    -  ╬ : noeud fermé</br></br>

Guide d'utilisation :</br>
    Au lancement du jar (ou du code) le programme attend un paramètre :</br>
    - 0 : génération aléatoire d'un labyrinthe avec textures aléatoires (attention, aucune garantie qu'il existe un chemin)</br>
    - 1 : génération d'un terrain entièrement vide avec textures aléatoires</br>
    - 2 : génération d'un labyrinthe avec des murs fixée et textures aléatoires</br></br>

A chaque itération de l'algorithme, pour le labyrinthe classique, vous avez un affichage complet du labyrinthe et ses états, noeuds ouverts et fermés, et le chemin final est affichés sur la dernière itération.
