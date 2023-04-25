public class Object {
    private String name;
    private int[] dimension;

    public Object(String name, int x , int y) {
        this.name = name;
        this.dimension = new int[2];
        this.dimension[0] = x;
        this.dimension[1] = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getDimension() {
        return dimension;
    }

    public void setDimension(int[] dimension) {
        this.dimension = dimension;
    }

    public int getX() {
        return dimension[0];
    }

    public int getY() {
        return dimension[1];
    }
}
