public class Food extends Objects {
    private int price;
    private int fullness;

    public Food(String name,  Inventory inventory) {
        super(name, inventory);
        switch(name){
            case "Nasi":
                this.price = 5;
                this.fullness = 5;
                break;
            case "Kentang":
                this.price = 3;
                this.fullness = 4;
                break;
            case "Ayam":
                this.price = 10;
                this.fullness = 8;
                break;
            case "Sapi":
                this.price = 12;
                this.fullness = 15;
                break;
            case "Wortel":
                this.price = 3;
                this.fullness = 2;
                break;
            case "Bayam":
                this.price = 3;
                this.fullness = 2;
                break;
            case "Kacang":
                this.price = 2;
                this.fullness = 2;
                break;
            case "Susu":
                this.price = 2;
                this.fullness = 1;
                break;
            default:
                this.price = 0;
                this.fullness = 0;
                break;
        }
        
    }

    public int getPrice() {
        return price;
    }

    public int getFullness() {
        return fullness;
    }
}