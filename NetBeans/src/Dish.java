import java.util.List;

public class Dish extends Objects implements Edible {
    private List<String> ingredients;
    private int fullness;
    private double time;

    public Dish(String name) throws IllegalArgumentException {
        super(name);
        switch (name) {
            case "Nasi Ayam":
                this.ingredients.add("Nasi");
                this.ingredients.add("Ayam");
                this.fullness = 16;
                this.time = 1.5 * fullness;
                break;
            case "Nasi Kari":
                this.ingredients.add("Nasi");
                this.ingredients.add("Kentang");
                this.ingredients.add("Wortel");
                this.ingredients.add("Sapi");
                this.fullness = 30;
                this.time = 1.5 * fullness;
                break;
            case "Susu Kacang":
                this.ingredients.add("Susu");
                this.ingredients.add("Kacang");
                this.fullness = 5;
                this.time = 1.5 * fullness;
                break;
            case "Tumis Sayur":
                this.ingredients.add("Wortel");
                this.ingredients.add("Bayam");
                this.fullness = 5;
                this.time = 1.5 * fullness;
                break;
            case "Bistik":
                this.ingredients.add("Sapi");
                this.ingredients.add("Kentang");
                this.fullness = 22;
                this.time = 1.5 * fullness;
                break;
            default:
                throw new IllegalArgumentException("Invalid dish name: " + name);
        }

    }

    public int getFullness() {
        return fullness;
    }

    public double getTime() {
        return time;
    }

    public String getIngredient() {
        return ingredients.toString();
    }
}
