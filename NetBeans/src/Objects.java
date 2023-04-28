import java.util.HashMap;

public abstract class Objects {
    private String name;
    private int amount;
    private Inventory inventory;

    public Objects(String name, Inventory inventory) {
        this.name = name;
        this.inventory = inventory;
        // inventory.addItems(name);
        // amount = inventory.getItems().get(name);
    }

    public String getName() {
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public HashMap<String, Integer> getInventory() {
        return inventory.getInventory();
    }
}
