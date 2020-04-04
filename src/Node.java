import java.util.ArrayList;
import java.util.Objects;

public abstract class Node {

    private int posX;
    private int posY;
    private boolean isOpen;
    private boolean isClose;
    private ArrayList<Node> neighbors;

    /**
     * Constructor of a node
     * @param x coordinate
     * @param y coordinate
     */
    public Node(int x, int y) {
        posX = x;
        posY = y;
        neighbors = new ArrayList<>();
    }

    /**
     * Return the position of x
     * @return the position of x
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Return the position of y
     * @return the position of y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Add a neighbour to the arraylist of neighbors
     * @param neighbour neighbour to add
     */
    public void addNeighbour(Node neighbour) {
        neighbors.add(neighbour);
    }

    /**
     * Return the arraylist of neighbors
     * @return the arraylist of neighbors
     */
    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    /**
     * Return true if the node is an empty node
     * @return true if the node is an empty node
     */
    public abstract boolean isEmpty();

    /**
     * Return the string of the node, to display it on terminal
     * @return the string of the node, to display it on terminal
     */
    public abstract String toString();

    /**
     * Set the string of the node as part of the path
     */
    public abstract void setString(String s);

    /**
     * Return true if the node is the start node
     * @return true if the node is the start node
     */
    public abstract boolean isStart();

    /**
     * Return true if the node is the end node
     * @return true if the node is the end node
     */
    public abstract boolean isEnd();

    /**
     * Return the cost of the node according to its texture (cobblestone, sand, water)
     * @return the cost of the node according to its texture (cobblestone, sand, water)
     */
    public abstract int getCost();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return posX == node.posX &&
                posY == node.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }

    /**
     * Return the string of the node
     * @return the string of the node
     */
    public abstract String getString();

    /**
     * Set the node as open node
     */
    public void setOpen() {
        isOpen = true;
        if(!isStart() && !isEnd()) {
            setString(" ┼ ");
        }
    }

    public void setClose() {
        isOpen = false;
        isClose = true;
        if(!isStart() && !isEnd()) {
            setString(" ╬ ");
        }
    }

    /**
     * Return true if the node is open
     * @return true if the node is open
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Return false if the node is close
     * @return false if the node is close
     */
    public boolean isClose() {
        return isClose;
    }
}
