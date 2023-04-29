import java.util.HashMap;

public abstract class Objects {
    private String name;

    public Objects(String name, Inventory inventory) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
