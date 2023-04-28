import java.util.List;

public class Dish extends Objects {
    private List<Dish> ingredients;
    private int fullness;
    private int time;

    public Dish(String name, Inventory inventory, int fullness, int time, List<Dish> ingredients) {
        super(name, inventory);
        this.fullness = fullness;
        this.time = time;
        this.ingredients = ingredients;
    }
    
    public int getFullness() {
        return fullness;
    }
    public int getTime() {
        return time;
    }
    public String getIngredient() {
        return ingredients.toString();
    }
}
