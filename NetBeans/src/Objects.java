public abstract class Objects {
    private String name;
    private int amount;

    public Objects(String name) {
        this.name = name;
        // inventory.addItems(name);
        // amount = inventory.getItems().get(name);
    }

    public String getName() {
        return name;
    }

    public int getAmount(){
        return amount;
    }
}
