public class Main {

    public static void main(String[] args) {

        int width = 15;
        int length = 15;
        int nbMaze = Integer.parseInt(args[0]);

        Maze maze = new Maze(width, length, nbMaze);

        maze.displayMaze();

        AStar astar = new AStar(maze);
        boolean res = astar.run();
        if(res) {
            System.out.println("Congratulation, you found a path!");
        }else{
            System.out.println("Game Over. No path found.");
        }

    }
}
