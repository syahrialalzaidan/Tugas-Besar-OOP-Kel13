public class Food extends Objects {
    private int price;
    private int fullness;

    public Food(String name, int price, int fullness) {
        super(name);
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