public class Sim {
    private String name;
    private Job job;
    private int money;
    private Inventory<Object> inventory;
    private House house;
    private int mood;
    private int health;
    private int fullness;
    private int ngantuk;
    private int kebelet;
    private int dailyWork;
    private boolean dailyPay;



    public Sim(String name, Job job, Inventory<Object> inventory, House house){
        this.name = name;
        this.job = job;
        this.money = 100;
        this.inventory = inventory;
        this.house = house;
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

    public Inventory<Object> getInventory(){
        return inventory;
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

    
    
    public void setName(String name){
        this.name = name;
    }

    public void setJob(Job job){
        this.job = job;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public void setInventory(Inventory<Object> inventory){
        this.inventory = inventory;
    }

    public void setHouse(){
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