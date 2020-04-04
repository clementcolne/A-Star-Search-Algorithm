# A Star Search Algorithm
</br>
Description of the characters displayed on the terminal:</br>
- ███: wall node</br>
- C: cobblestone node</br>
- S: sand node</br>
- W: water node</br>
- STA: start node</br>
- END: end node</br>
- ≡≡≡: node part of the final path</br>
- ┼: open node</br>
- ╬: closed node</br>
</br>
User manual :</br>
The main expects a parameter :</br>
- 0: random generation of the maze with random nodes /!\ be careful, no guarantee that there is a path /!\</br>
- 1: generation of an empty maze (i.e. no wall nodes) with random nodes</br>
- 2: generation of a maze with predefined walls and random nodes</br>
</br>
At each iteration of the algorithm, the maze is displayed with its states: open and closed nodes. The final path is displayed on the last iteration.</br>
</br>
How to run:</br>
- Using jar: with the terminal, in the folder of the jar, using "java -jar maze.jar" command (note : this jar has been compiled with java 8)</br>
- Using code: with the terminal, in the folder of the jar, using "javac Main.java" command, and "java Main.class mazeNumber
" to execute
