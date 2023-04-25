import java.util.List;

public class Food extends Objects {
    private List<Food> ingredients;
    private int fullness;
    private int time;

    public Food(String name, Inventory inventory, int fullness, int time, List<Food> ingredients) {
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
    public String getIngredients() {
        return ingredients.toString();
    }
}
