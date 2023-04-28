import java.util.ArrayList;
import java.util.List;

public class InventoryDriver {
    public static void main(String[] args) {
        Inventory<Items> itemsInventory = new Inventory<>("Items", "Dolly");
        Inventory<Dish> dishInventory = new Inventory<>("Dish", "Dolly");

        Items kasurSingle = new Items("Kasur Single", 1, 20, 200);
        Items kasurQueen = new Items("Kasur Queen Size", 1,2, 200);
        Items toilet = new Items("Toilet", 20, 10, 100);

        List<String> ingredients = new ArrayList<>();
        ingredients.add("tepung");
        ingredients.add("air");
        Dish roti = new Dish("Roti", 1, 2, ingredients);

        itemsInventory.addInventory(kasurSingle);
        itemsInventory.addInventory(kasurQueen);
        itemsInventory.addInventory(kasurQueen);
        dishInventory.addInventory(roti);

        System.out.println(itemsInventory.getInventoryType());      // Items
        System.out.println(itemsInventory.getValue(kasurSingle));   // 1
        System.out.println(itemsInventory.getValue(kasurQueen));    // 2
        itemsInventory.printInventory();

        System.out.println(dishInventory.getInventoryType());       // Dish
        System.out.println(dishInventory.getValue(roti));           // 1
        dishInventory.printInventory();
        /*
         * List of items in inventory
         * Kasur Queen Size = 2
         * Kasur Single = 1
         */
        try {
            // Call reduceInventory() method and pass in the name of the item to reduce inventory
            itemsInventory.reduceInventory(toilet);
        } catch (Exception e) {
            // Catch the exception and handle it appropriately
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Call reduceInventory() method and pass in the name of the item to reduce inventory
            itemsInventory.reduceInventory(kasurSingle);
        } catch (Exception e) {
            // Catch the exception and handle it appropriately
            System.out.println("Error: " + e.getMessage());
        }

    }
}
