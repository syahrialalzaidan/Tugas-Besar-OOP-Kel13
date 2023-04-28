public class Food extends Objects {
    private int price;
    private int fullness;

    public Food(String name,  Inventory<Food> inventory, int price, int fullness) {
        super(name, inventory);
        this.price = price;
        this.fullness = fullness;
    }

    public int getPrice() {
        return price;
    }

    public int getFullness() {
        return fullness;
    }
}