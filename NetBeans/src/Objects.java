import java.util.HashMap;

public abstract class Objects {
    private String name;
<<<<<<< Updated upstream
    private int amount;
    private Inventory inventory;
=======
>>>>>>> Stashed changes

    public Objects(String name, Inventory inventory) {
        this.name = name;
<<<<<<< Updated upstream
        this.inventory = inventory;
        // inventory.addItems(name);
        // amount = inventory.getItems().get(name);
=======
>>>>>>> Stashed changes
    }

    public String getName() {
        return name;
    }
<<<<<<< Updated upstream

    public int getAmount(){
        return amount;
    }

    public HashMap<String, Integer> getInventory() {
        return inventory.getInventory();
    }
=======
>>>>>>> Stashed changes
}
