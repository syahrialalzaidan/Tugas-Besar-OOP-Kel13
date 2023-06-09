public class Items extends Objects {
    private int[] dimension = new int[2];
    private int price;
    private String action;

    public Items(String name) {
        super(name);
        switch (name) {
            case "Kasur Single":
                this.dimension[0] = 4;
                this.dimension[1] = 1;
                this.price = 50;
                action = "Tidur";
                break;
            case "Kasur Queen Size":
                this.dimension[0] = 4;
                this.dimension[1] = 2;
                this.price = 100;
                action = "Tidur";
                break;
            case "Kasur King Size":
                this.dimension[0] = 5;
                this.dimension[1] = 2;
                this.price = 150;
                action = "Tidur";
                break;
            case "Toilet":
                this.dimension[0] = 1;
                this.dimension[1] = 1;
                this.price = 50;
                action = "Buang air";
                break;
            case "Kompor Gas":
                this.dimension[0] = 2;
                this.dimension[1] = 1;
                this.price = 100;
                action = "Memasak";
                break;
            case "Kompor Listrik":
                this.dimension[0] = 1;
                this.dimension[1] = 1;
                this.price = 200;
                action = "Memasak";
                break;
            case "Meja dan Kursi":
                this.dimension[0] = 3;
                this.dimension[1] = 3;
                this.price = 50;
                action = "Makan";
                break;
            case "Jam":
                this.dimension[0] = 1;
                this.dimension[1] = 1;
                this.price = 10;
                action = "Melihat waktu";
                break;
            case "HP":
                this.dimension[0] = 1;
                this.dimension[1] = 1;
                this.price = 100;
                action = "Scroll SimTok";
                break;
            case "Sajadah":
                this.dimension[0] = 1;
                this.dimension[1] = 1;
                this.price = 10;
                action = "Sholat";
                break;
            case "Sapu":
                this.dimension[0] = 1;
                this.dimension[1] = 1;
                this.price = 10;
                action = "Membersihkan Rumah";
                break;
            case "TV":
                this.dimension[0] = 2;
                this.dimension[1] = 2;
                this.price = 100;
                action = "Menonton";
                break;
            case "Laptop":
                this.dimension[0] = 1;
                this.dimension[1] = 1;
                this.price = 200;
                action = "Main game";
                break;
            case "Shower":
                this.dimension[0] = 1;
                this.dimension[1] = 1;
                this.price = 50;
                action = "Mandi";
                break;
            case "Kolam Renang" :
                this.dimension[0]= 3;
                this.dimension[1]= 3;
                this.price = 200;
                action = "Berenang";
            default:
                this.dimension[0] = 1;
                this.dimension[1] = 1;
                this.price = 0;
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