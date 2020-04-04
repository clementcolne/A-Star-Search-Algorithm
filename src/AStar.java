import java.util.ArrayList;
import java.util.HashMap;

public class AStar {

    private Maze maze;
    private ArrayList<Node> visitedNodes;
    private HashMap<Node, Node> predecessors;
    private HashMap<Node, Integer>g;
    private HashMap<Node, Integer>f;
    private ArrayList<Node> states;

    /**
     * AStar constructor
     * @param maze Maze
     */
    public AStar(Maze maze) {
        this.maze = maze;
        init();
    }

    /**
     * initialize before A* algorithm
     */
    public void init() {
        visitedNodes = new ArrayList<>();
        predecessors = new HashMap<>();
        states = new ArrayList<>();
        visitedNodes.add(maze.getStart());
        g = new HashMap<>();
        f = new HashMap<>();
    }

    /**
     * Calcul de l'heuristique : distance euclidienne via le théorème de pythagore de la case en paramètres à la sortie
     * @param start Case du début de la distance
     * @return heuristique
     */
    public int h(Node start) {
        return (int)Math.pow((int)Math.sqrt(Math.pow(Math.abs(start.getPosX() - maze.getEnd().getPosX()), 2) + Math.pow(Math.abs(start.getPosY() - maze.getEnd().getPosY()), 2)), 2);
    }

    /**
     * Calcule le meilleur noeud à utiliser parmi les cases ouvertes
     * @return le meilleur noeud
     */
    public Node getBestNode() {
        int tmp = Integer.MAX_VALUE;
        Node bestNode = maze.getStart();
        for(Node n : visitedNodes) {
            if(f.get(n) < tmp) {
                bestNode = n;
                tmp = f.get(n);
            }
        }
        return bestNode;
    }

    /**
     * Retourne le coût pour passer de la case start à la case end
     * @param n case end
     * @return le coût pour passer de la case start à la case end
     */
    public int getWeight(Node n) {
        return n.getCost();
    }

    /**
     * Calcule un chemin de l'entrée à la sortie du labyrinthe selon l'algorithme A*
     * @return un chemin de l'entrée à la sortie du labyrinthe selon l'algorithme A*
     */
    public boolean run() {
        int gBuffer;
        Node currentNode;
        Node start = maze.getStart();
        Node end = maze.getEnd();

        start.setOpen();
        visitedNodes.add(start);

        for(int i = 0; i < maze.getWidth() ; i++) {
            for(int j = 0; j < maze.getLength() ; j++) {
                g.put(maze.getNode(i, j), Integer.MAX_VALUE);
                f.put(maze.getNode(i, j), Integer.MAX_VALUE);
            }
        }

        g.put(start, 0);
        f.put(start, h(start));

        while(!visitedNodes.isEmpty()) {
            currentNode = getBestNode();
            // we set the node as open node
            currentNode.setOpen();

            if(currentNode.equals(end)) {
                // congrat's, you found the target node
                reconstructFinalPath(currentNode);
                return true;
            }

            // still not found the target node, let's work a bit more
            visitedNodes.remove(currentNode);
            currentNode.setClose();
            for(Node neighbour : currentNode.getNeighbors()) {
                if(neighbour.isEmpty()) {
                    // we look at the node only if it's not a wall
                    gBuffer = g.get(currentNode) + getWeight(neighbour);
                    displayStates();
                    if (gBuffer < g.get(neighbour)) {
                        predecessors.put(neighbour, currentNode);
                        states.add(neighbour);
                        g.put(neighbour, gBuffer);
                        f.put(neighbour, g.get(neighbour) + h(neighbour));
                        if (!visitedNodes.contains(neighbour)) {
                            visitedNodes.add(neighbour);
                            neighbour.setOpen();
                        }
                    }
                }
            }
        }
        // the visited nodes arraylist is empty, we didn't found the end, game is over.
        return false;
    }

    /**
     * Display the maze depending of its type (classic node, open node or close node)
     */
    public void displayStates() {
        maze.displayMaze();
    }

    /**
     * Reconstruct the path of the algorithm from start node to end node and displkay the maze
     * @param current current node
     */
    public void reconstructFinalPath(Node current) {
        while(predecessors.get(current) != null) {
            current = predecessors.get(current);
            if(!current.isEnd() && !current.isStart()) {
                current.setString("≡≡≡");
            }
        }
        maze.displayMaze();
    }

}
