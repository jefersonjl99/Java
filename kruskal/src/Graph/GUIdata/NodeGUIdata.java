package Graph.GUIdata;

public class NodeGUIdata {
    protected boolean visited = false;
    protected int x = 0;
    protected int y = 0;

    protected Integer unionIndex = null;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public Integer getUnionIndex() {
        return this.unionIndex;
    }

    public void setUnionIndex(Integer unionIndex) {
        this.unionIndex = unionIndex;
    }


}
