public class EndNode extends Node {

    private String string;
    private boolean isOpen;
    private boolean isClose;

    /**
     * Constructor of the end node
     * @param x coordinate
     * @param y coordinate
     */
    public EndNode(int x, int y) {
        super(x, y);
        string = "END";
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isEnd() {
        return true;
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

    public int getCost() {
        return 0;
    }

    public String getString() {
        return string;
    }

}
