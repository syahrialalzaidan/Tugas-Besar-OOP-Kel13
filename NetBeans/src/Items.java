public class Items extends Objects {
    private int[] dimension;
    private int price;
    private String action;

    public Items(String name, int x, int y, int price) {
        super(name);
        this.dimension = new int[2];
        this.dimension[0] = x;
        this.dimension[1] = y;
        this.price = price;
        switch (name) {
            case "Kasur Single":
                action = "Tidur";
                break;
            case "Kasur Queen Size":
                action = "Tidur";
                break;
            case "Kasur King Size":
                action = "Tidur";
                break;
            case "Toilet":
                action = "Buang air";
                break;
            case "Kompor Gas":
                action = "Memasak";
                break;
            case "Kompor Listrik":
                action = "Memasak";
                break;
            case "Meja dan Kursi":
                action = "Makan";
                break;
            case "Jam":
                action = "Melihat waktu";
                break;
            default:
                action = "Menggunakan";
                break;
        }
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

    public int getPrice() {
        return price;
    }

    public String getAction() {
        return action;
    }
}
