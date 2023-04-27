public class Items extends Objects {
    private int size;
    private int price;
    private String action;

    public Items(String name, Inventory<Items> inventory, int size, int price) {
        super(name, inventory);
        this.size = size;
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

    public int getSize() {
        return size;
    }
    public int getPrice() {
        return price;
    }
    public String getAction() {
        return action;
    }
}
