public class InventoryDriver {
    public static void main(String[] args) {
        // Inventory foodInventory = new Inventory<Food>("Food", "Dolly");
        Inventory<Items> itemsInventory = new Inventory<>("Items", "Dolly");
        Items kasurSingle = new Items("Kasur Single", itemsInventory, 20, 2000);
        Items kasurQueen = new Items("Kasur Queen Size", itemsInventory, 200, 2000);
    }
}
