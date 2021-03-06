public class SandNode extends Node {

    private String string;
    private boolean isOpen;
    private boolean isClose;

    /**
     * Constructor of an empty node
     * A node can be cobblestone (cost 1), sand (cost 2) or water (cost 3)
     * @param x coordinate
     * @param y coordinate
     */
    public SandNode(int x, int y) {
        super(x, y);
        string = " S ";
    }

    public boolean isEmpty() {
        return true;
    }

    public void setString(String s) {
        this.string = s;
    }

    public String toString() {
        return string;
    }

    public boolean isStart() {
        return false;
    }

    public boolean isEnd() {
        return false;
    }

    public int getCost() {
        return 2;
    }

    public String getString() {
        return string;
    }

}
