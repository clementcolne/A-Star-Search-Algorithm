public class StartNode extends Node {

    private String string;
    private boolean isOpen;
    private boolean isClose;

    /**
     * Constructor of the start node
     * @param x coordinate
     * @param y coordinate
     */
    public StartNode(int x, int y) {
        super(x, y);
        string = "STA";
    }

    public boolean isStart() {
        return true;
    }

    public boolean isEnd() {
        return false;
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

    public int getCost() {
        return 0;
    }

    public String getString() {
        return string;
    }

}
