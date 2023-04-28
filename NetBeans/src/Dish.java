import java.util.List;

public class Dish extends Objects {
    private List<String> ingredients;
    private int fullness;
    private int time;

    public Dish(String name, int fullness, int time, List<String> ingredients) {
        super(name);
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
