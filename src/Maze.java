import java.util.Random;

public class Maze {

    private Node[][] maze;
    private int width;
    private int length;
    private Node start;
    private Node end;

    /**
     * Constructor of a maze
     * @param width width of the maze
     * @param length length of the maze
     * @param nbMaze if false, the laby is a random laby, if true, it's a prebuild laby
     */
    public Maze(int width, int length, int nbMaze) {
        int random;
        Random rand = new Random();

        // initializes the maze with its dimensions
        maze = new Node[width][length];
        this.width = width;
        this.length = length;

        if(nbMaze == 0) {
            // first trail to create the maze
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    random = rand.nextInt(4);
                    if (random == 0) {
                        addWallNode(i, j);
                    } else {
                        if (random == 1) {
                            addCobblestoneNode(i, j);
                        } else if (random == 2) {
                            addSandNode(i, j);
                        } else {
                            addWaterNode(i, j);
                        }
                    }
                }
            }
            addStart();
            addEnd();
        }else if (nbMaze == 1) {
            preBuildMaze1();
        }else{
            preBuildMaze2();
        }

        // add all accessible neighbors
        addNeighbors();
    }

    /**
     * Add a cobblestone node
     * @param x coordinate
     * @param y coordinate
     */
    public void addCobblestoneNode(int x, int y) {
        maze[x][y] = new CobblestoneNode(x, y);
    }

    /**
     * Add a sand node
     * @param x coordinate
     * @param y coordinate
     */
    public void addSandNode(int x, int y) {
        maze[x][y] = new SandNode(x, y);
    }

    /**
     * Add a water node
     * @param x coordinate
     * @param y coordinate
     */
    public void addWaterNode(int x, int y) {
        maze[x][y] = new WaterNode(x, y);
    }

    /**
     * Add the start node
     * @param x coordinate
     * @param y coordinate
     */
    public void addStartNode(int x, int y) {
        maze[x][y] = new StartNode(x, y);
        start = maze[x][y];
    }

    /**
     * Add the end node
     * @param x coordinate
     * @param y coordinate
     */
    public void addEndNode(int x, int y) {
        maze[x][y] = new EndNode(x, y);
        end = maze[x][y];
    }

    /**
     * Add a wall node
     * @param x coordinate
     * @param y coordinate
     */
    public void addWallNode(int x, int y) {
        maze[x][y] = new WallNode(x, y);
    }

    /**
     * Add the start node
     */
    public void addStart() {
        Random rand = new Random();
        int randWidth = rand.nextInt(length);
        int randLength = rand.nextInt(width);
        while(!maze[randWidth][randLength].isEmpty()) {
            randWidth = rand.nextInt(length);
            randLength = rand.nextInt(width);
        }
        maze[randWidth][randLength] = new StartNode(randWidth, randLength);
        start = maze[randWidth][randLength];
    }

    /**
     * Add the end node
     */
    public void addEnd() {
        Random rand = new Random();
        int randWidth = rand.nextInt(length);
        int randLength = rand.nextInt(length);
        while(!maze[randWidth][randLength].isEmpty() && maze[randWidth][randLength].isStart()) {
            randWidth = rand.nextInt(length);
            randLength = rand.nextInt(length);
        }
        maze[randWidth][randLength] = new EndNode(randWidth, randLength);
        end = maze[randWidth][randLength];
    }

    /**
     * Return the start node
     * @return the start node
     */
    public Node getStart() {
        return start;
    }

    /**
     * Return the end node
     * @return the end node
     */
    public Node getEnd() {
        return end;
    }

    /**
     * Return the width of the maze
     * @return the width of the maze
     */
    public int getWidth() {
        return width;
    }

    /**
     * Return the length of the node
     * @return the length of the node
     */
    public int getLength() {
        return length;
    }

    /**
     * Return the node at the coordinates given in parameters
     * @param x coordinate
     * @param y coordinate
     * @return the node at the coordinates given in parameters
     */
    public Node getNode(int x, int y) {
        return maze[x][y];
    }

    /**
     * Add all the accessible (= not a wall) neighbors of each nodes of the maze
     */
    public void addNeighbors() {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < length; j++) {
                if(i == 0 && j == 0) {
                    // top left hand corner
                    maze[i][j].addNeighbour(maze[i + 1][j]);
                    maze[i][j].addNeighbour(maze[i][j + 1]);
                }else if(i == width - 1 && j == 0) {
                    // top right hand corner
                    maze[i][j].addNeighbour(maze[i - 1][j]);
                    maze[i][j].addNeighbour(maze[i][j + 1]);
                }else if(i == 0 && j == length - 1) {
                    // bottom left hand corner
                    maze[i][j].addNeighbour(maze[i + 1][j]);
                    maze[i][j].addNeighbour(maze[i][j - 1]);
                }else if(i == width - 1 && j == length - 1) {
                    // top right hand corner
                    maze[i][j].addNeighbour(maze[i - 1][j]);
                    maze[i][j].addNeighbour(maze[i][j - 1]);
                }else if(j == 0) {
                    // top border
                    maze[i][j].addNeighbour(maze[i - 1][j]);
                    maze[i][j].addNeighbour(maze[i + 1][j]);
                    maze[i][j].addNeighbour(maze[i][j + 1]);
                }else if(i == 0) {
                    // left border
                    maze[i][j].addNeighbour(maze[i + 1][j]);
                    maze[i][j].addNeighbour(maze[i][j - 1]);
                    maze[i][j].addNeighbour(maze[i][j + 1]);
                }else if(j == length - 1) {
                    // bottom border
                    maze[i][j].addNeighbour(maze[i + 1][j]);
                    maze[i][j].addNeighbour(maze[i - 1][j]);
                    maze[i][j].addNeighbour(maze[i][j  - 1]);
                }else if(i == width - 1) {
                    // right border
                    maze[i][j].addNeighbour(maze[i][j + 1]);
                    maze[i][j].addNeighbour(maze[i][j - 1]);
                    maze[i][j].addNeighbour(maze[i - 1][j]);
                }else{
                    // other cases
                    maze[i][j].addNeighbour(maze[i][j + 1]);
                    maze[i][j].addNeighbour(maze[i + 1][j]);
                    maze[i][j].addNeighbour(maze[i][j - 1]);
                    maze[i][j].addNeighbour(maze[i - 1][j]);
                }
            }
        }
    }

    /**
     * Display the maze on the terminal
     */
    public void displayMaze() {
        System.out.print("█");
        for(int i = 0; i < width * 3 ; i++) {
            System.out.print("█");
        }
        System.out.print("██\n");

        for(int i = 0; i < length; i++) {
            System.out.print("█");
            for(int j = 0; j < width; j++) {
                System.out.print(maze[i][j].toString());
            }
            System.out.print("██\n");
        }
        System.out.print("█");
        for(int i = 0; i < width * 3 ; i++) {
            System.out.print("█");
        }
        System.out.print("██\n\n");
    }

    /**
     * Create a prebuild maze with width : 15, length : 15
     */
    public void preBuildMaze1() {
        String prebuildMaze[][] = {
                {"STA", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "END"},
        };

        for(int i = 0 ; i < width ; i++) {
            for (int j = 0; j < length; j++) {
                switch (prebuildMaze[i][j]) {
                    case " ":
                        addWallNode(i, j);
                        break;
                    case "G":
                        Random rand = new Random();
                        int node = rand.nextInt(3);
                        if(node == 0) {
                            addCobblestoneNode(i, j);
                        }else if(node == 1) {
                            addSandNode(i, j);
                        }else{
                            addWaterNode(i, j);
                        }
                        break;
                    case "STA":
                        addStartNode(i, j);
                        break;
                    case "END":
                        addEndNode(i, j);
                        break;
                }
            }
        }
    }

    /**
     * Create a prebuild maze with width : 15, length : 15
     */
    public void preBuildMaze2() {
        String prebuildMaze[][] = {
                {"STA", " ","G", "G", "G", " ", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", " ", "G", " ", "G", " ", "G", " ", "G", " ", "G", " ", " ", " ", " "},
                {"G", "G", "G", " ", "G", " ", "G", " ", "G", " ", "G", " ", "G", "G", "G"},
                {" ", " ", " ", "G", "G", " ", "G", "G", "G", " ", "G", " ", "G", " ", "G"},
                {"G", "G", " ", "G", " ", " ", "G", " ", " ", " ", "G", " ", "G", " ", "G"},
                {" ", "G", "G", "G", "G", " ", "G", " ", "G", "G", "G", " ", "G", " ", "G"},
                {"G", "G", " ", " ", "G", " ", "G", " ", "G", " ", "G", " ", "G", " ", "G"},
                {"G", " ", " ", "G", "G", " ", "G", " ", "G", " ", " ", " ", "G", " ", "G"},
                {"G", "G", " ", " ", "G", "G", "G", " ", "G", "G", "G", "G", "G", " ", "G"},
                {"G", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {"G", " ", "G", "G", "G", "G", "G", " ", "G", "G", "G", "G", "G", "G", "G"},
                {"G", " ", "G", " ", " ", " ", "G", " ", "G", " ", " ", " ", " ", " ", "G"},
                {"G", " ", "G", "G", " ", "G", "G", " ", "G", "G", "G", "G", "G", " ", "G"},
                {"G", " ", " ", "G", " ", "G", " ", " ", " ", " ", " ", " ", "G", " ", "G"},
                {"G", "G", "G", "G", " ", "G", "G", "G", "G", "G", "G", "G", "G", " ", "END"},
        };

        for(int i = 0 ; i < width ; i++) {
            for (int j = 0; j < length; j++) {
                switch (prebuildMaze[i][j]) {
                    case " ":
                        addWallNode(i, j);
                        break;
                    case "G":
                        Random rand = new Random();
                        int node = rand.nextInt(3);
                        if(node == 0) {
                            addCobblestoneNode(i, j);
                        }else if(node == 1) {
                            addSandNode(i, j);
                        }else{
                            addWaterNode(i, j);
                        }
                        break;
                    case "STA":
                        addStartNode(i, j);
                        break;
                    case "END":
                        addEndNode(i, j);
                        break;
                }
            }
        }
    }
}
