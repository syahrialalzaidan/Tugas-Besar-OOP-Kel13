public class Point {
    private int x;
    private int y;

    public Point(int x , int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be positive");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0) {
            throw new IllegalArgumentException("y must be positive");
        }
        this.y = y;
    }

    // public String toString() {
    //     return "(" + x + "," + y + ")";
    // }
}
