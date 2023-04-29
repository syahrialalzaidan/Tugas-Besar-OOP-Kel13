import java.util.Random;


public class Sim {
    private String name;
    private Job job;
    private int money;
    private Inventory<Food> inventoryfood;
    private Inventory<Items> inventoryitems;
    private Inventory<Dish> inventorydish; 
    private House house;
    private int mood;
    private int health;
    private int fullness;
    private int ngantuk;
    private int kebelet;
    private int dailyWork;
    private boolean dailyPay;

    private static final String[] jobChoices = {"Badut Sulap", "Koki", "Polisi", "Programmer", "Dokter", "Mata-mata", "Pengacara"};


    public Sim(String name){
        this.name = name;
        Random rand = new Random();
        this.job = new Job(jobChoices[rand.nextInt(jobChoices.length)]);
        this.money = 100;
        this.inventoryfood = new Inventory<Food>("Food", name);
        this.inventoryitems = new Inventory<Items>("Items", name);
        this.inventorydish = new Inventory<Dish>("Dish", name);
        this.house = new House(new Point(0, 0));
        this.mood = 80;
        this.health = 80;
        this.fullness = 80;
        this.ngantuk = 0;
        this.kebelet = 0;
        this.dailyWork = 0;
        this.dailyPay = false;
    }

    public String getName(){
        return name;
    }

    public Job getJob(){
        return job;
    }

    public int getMoney(){
        return money;
    }

    public Inventory<Food> getInventoryfood(){
        return inventoryfood;
    }

    public Inventory<Items> getInventoryitems(){
        return inventoryitems;
    }

    public Inventory<Dish> getInventorydish(){
        return inventorydish;
    }

    public House getHouse(){
        return house;
    }

    public int getMood(){
        return mood;
    }

    public int getHeath(){
        return health;
    }

    public int getFullness(){
        return fullness;
    }

    public int getDailyWork(){
        return dailyWork;
    }

    public boolean getDailyPay(){
        return dailyPay;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void setJob(Job job){
        this.job = job;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public void setHouse(House house){
        this.house = house;
    }
    
    public void isNgantuk(){
        if (ngantuk>=600){
            mood-=5;
            health=-5;
            ngantuk-=600;
        }
        
    }
    public void isKebelet(){
        if (kebelet>=240){
            mood-=5;
            health=-5;
            ngantuk-=240;
        }
    }
}