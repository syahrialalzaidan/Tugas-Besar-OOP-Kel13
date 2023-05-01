public class SimDriver {

    public static void main(String[] args) throws Exception{
        Sim sim = new Sim("asd", new House(new Point(0, 0)), new World());
        Dish a = new Dish("Nasi Kari");
        GameManager qw = new GameManager();
        sim.eat(a,sim.getInventorydish(),sim.getInventoryfood());
    }
}

