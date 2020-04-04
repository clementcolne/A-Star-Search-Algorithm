public class WallNode extends Node {

    private String string;
    private boolean isOpen;
    private boolean isClose;

    /**
     * Constructor of a wall node
     * @param x coordinate
     * @param y coordinate
     */
    public WallNode(int x, int y) {
        super(x, y);
        string = "███";
    }

    public boolean isEmpty() {
        return false;
    }

    public String toString() {
        return string;
    }

    public void setString(String s) {
        this.string = s;
    }

    public boolean isStart() {
        return false;
    }

    public boolean isEnd() {
        return false;
    }

    public int getCost() {
        return Integer.MAX_VALUE;
    }

    public String getString() {
        return string;
    }

}
