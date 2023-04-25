public class DriverIyal {
    public static void main(String[] args) {
        //ini nanti diinit di main, berdasarkan kelas2nya
        Inventory inventory = new Inventory();

        
        Items kasurSingle = new Items("Kasur Single", inventory, 1, 100000);
        System.out.println(inventory.getItems());
        System.out.println("memek");
        Items kasurSingle1 = new Items("Kasur Single", inventory, 1, 100000);
        System.out.println(inventory.getItems());
        System.out.println(kasurSingle.getName());
        System.out.println(kasurSingle1.getAmount());
    }
}