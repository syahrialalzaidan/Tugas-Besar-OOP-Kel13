public class InventoryDriver {
    public static void main(String[] args) {
        Inventory<Items> itemsInventory = new Inventory<>("Items", "Dolly");
        Items kasurSingle = new Items("Kasur Single", itemsInventory, 20, 200);
        Items kasurQueen = new Items("Kasur Queen Size", itemsInventory, 40, 400);
        Items toilet = new Items("Toilet", itemsInventory, 10, 100);

        itemsInventory.addInventory(kasurSingle);
        itemsInventory.addInventory(kasurQueen);
        itemsInventory.addInventory(kasurQueen);

        System.out.println(itemsInventory.getInventoryType());      // Items
        System.out.println(itemsInventory.getValue(kasurSingle));   // 1
        System.out.println(itemsInventory.getValue(kasurQueen));    // 2
        itemsInventory.printInventory();
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
