import java.util.ArrayList;
import java.util.List;

public class InventoryDriver {
    public static void main(String[] args) throws Exception {
        Inventory<Items> itemsInventory = new Inventory<>("Items", "Dolly");
        Inventory<Dish> dishInventory = new Inventory<>("Dish", "Dolly");

        Items kasurSingle1 = new Items("Kasur Single");
        Items kasurSingle2 = new Items("Kasur Single");
        Items kasurQueen1 = new Items("Kasur Queen Size");
        Items toilet = new Items("Toilet");

        List<String> ingredients = new ArrayList<>();
        ingredients.add("tepung");
        ingredients.add("air");
        Dish roti = new Dish("Roti", 1, 2, ingredients);

        itemsInventory.addInventory(kasurSingle1);
        itemsInventory.addInventory(kasurSingle2);
        itemsInventory.addInventory(kasurQueen1);
        dishInventory.addInventory(roti);

        System.out.println(itemsInventory.getInventoryType());      // Items
        System.out.println(itemsInventory.getValue(kasurSingle1));   // 2
        System.out.println(itemsInventory.getValue("Kasur Single"));    // 2
        itemsInventory.printInventory();
        /*
         * List of items in inventory
         * Kasur Queen Size = 2
         * Kasur Single = 1
         */

        System.out.println(dishInventory.getInventoryType());       // Dish
        System.out.println(dishInventory.getValue(roti));           // 1
        dishInventory.printInventory();
        /*
         * List of Dish in inventory
         * Roti = 1
         */

        // System.out.println("Trying to reduce toilet");
        // try {
        //     // Call reduceInventory() method and pass in the name of the item to reduce inventory
        //     itemsInventory.reduceInventory(toilet);
        // } catch (Exception e) {
        //     // Catch the exception and handle it appropriately
        //     System.out.println("Error: " + e.getMessage());
        // }
      
        try {
            // Call reduceInventory() method and pass in the name of the item to reduce inventory
            itemsInventory.reduceInventory(toilet);
        } catch (Exception e) {
            // Catch the exception and handle it appropriately
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Call reduceInventory() method and pass in the name of the item to reduce inventory
            itemsInventory.reduceInventory(kasurSingle1);
        } catch (Exception e) {
            // Catch the exception and handle it appropriately
            System.out.println("Error: " + e.getMessage());
        }
        itemsInventory.printInventory();
        /*
         * List of Items in inventory
         * Kasur Single = 1
         * Kasur Queen Size = 1
         */

        System.out.println("Trying to get kasursingle");
        // Kasur Single is deleted from inventory because the amount is now 0.
        Items kasurSingle = itemsInventory.getInventoryElement("Kasur Single");
        System.out.println(kasurSingle);            // Item@xxxx
        System.out.println(kasurSingle.getName());  // "Kasur Single"
        Items kasurQueen = itemsInventory.getInventoryElement(kasurQueen1);
        // Kasur Queen is deleted from inventory because the amount is now 0.
        itemsInventory.printInventory();
        // Inventory is empty. Buy some stuff?
    }
}
