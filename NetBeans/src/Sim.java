import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Sim {

    private String name;
    private Job job;
    private int money;
    private Inventory<Food> inventoryfood;
    private Inventory<Items> inventoryitems;
    private Inventory<Dish> inventorydish; 
    private House house;
    private World world;
    private int mood;
    private int health;
    private int fullness;
    private int kebelet;
    private boolean afterEating;
    private int dailyWork;
    private int dailySleep;
    private int dailyPay;
    private House currentHouse;
    private boolean alive;
    private int berkunjung;
    private boolean isBerkunjung;
    private Room currentRoom;
    private Items currentItems;
    private List<Pair<String,Integer,Integer>> itemOrder = new ArrayList<Pair<String,Integer,Integer>>();
    private List<Pair<String,Integer,Integer>> foodOrder = new ArrayList<Pair<String,Integer,Integer>>();
    Scanner input = new Scanner(System.in);
  

    Random rand = new Random();


    public Sim(String name,House house, World world){
        this.name = name;
        this.job = new Job(rand.nextInt(1, 8));
        this.world = world;
        this.money = 2000;
        this.inventoryfood = new Inventory<Food>("Food", name);
        this.inventoryitems = new Inventory<Items>("Items", name);
        this.inventorydish = new Inventory<Dish>("Dish", name);
        this.house = house;
        this.mood = 80;
        this.health = 80;
        this.fullness = 80;
        this.kebelet = 0;
        this.afterEating = false;
        this.dailyWork = 0;
        this.dailySleep = 0;
        this.dailyPay = 1;
        this.currentHouse = house;
        this.alive = true;  
        this.berkunjung=0;
        this.isBerkunjung = false;
        this.currentRoom = house.getRoom(0);
        this.currentItems = null;

    }

    public String getName(){
        return name;
    }

    public Job getJob(){
        return job;
    }
    
    public boolean getisBerkunjung(){
        return isBerkunjung;
    }
    
    public Room getCurrentRoom(){
        return currentRoom;
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

    public void addInventoryfood(Food food){
        inventoryfood.addInventory(food);
    }

    public void addInventoryitems(Items items){
        inventoryitems.addInventory(items);
    }

    public void addInventorydish(Dish dish){
        inventorydish.addInventory(dish);
    }
    public House getHouse(){
        return house;
    }

    public House getCurrHouse(){
        return currentHouse;
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

    public int getKebelet(){
        return kebelet;
    }

    public boolean getAfterEating(){
        return afterEating;
    }

    public int getDailyPay(){
        return dailyPay;
    }

    public int getDailySleep(){
        return dailySleep;
    }

    public int getDailyWork(){
        return dailyWork;
    }

    public boolean getAlive(){
        return alive;
    }

    public int getBerkunjung(){
        return berkunjung;
    }

    public Items getCurrentItems(){
        return currentItems;
    }
    
    public void setBerkunjung(boolean isBerkunjung){
        this.isBerkunjung = isBerkunjung;
    }

    public void setCurrentRoom(Room room){
        currentRoom = room;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSimJob(String jobname) throws Exception{
        this.job.setJob(jobname);}

    public void setMoney(int money){
        this.money = money;
    }

    public void setMood(int mood){
        this.mood = mood;
        if (this.mood>100){
            this.mood = 100;
        }
        if (this.mood<0){
            alive = false;
        }
    }

    public void setHeath(int health){
        this.health =  health;
        if (this.health>100){
            this.health = 100;
        }
        if (this.health<0){
            alive = false;
        }
    }

    public void setFullness(int fullness){
        this.fullness = fullness;
        if (this.fullness>100){
            this.fullness = 100;
        }
        if (this.fullness<0){
            alive = false;
        }
    }

    public void setKebelet(int kebelet){
        this.kebelet = kebelet;
    }

    public void setHouse(House house){
        this.house = house;
    }

    public void setCurrentHouse(House house){
        currentHouse = house;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }
    
    public void setBerkunjung(int berkunjung){
        this.berkunjung = berkunjung;
    }

    public void setCurrentItems(Items items){
        currentItems = items;
    }

    public void addItemOrder(String A, int B, int C){
        itemOrder.add(new Pair<>(A,B,C));

    }

    public void addFoodOrder(String A, int B, int C){
        foodOrder.add(new Pair<>(A,B,C));

    }

    public List<Pair<String,Integer,Integer>> getFoodOrder(){
        return foodOrder;
    }

    public List<Pair<String,Integer,Integer>> getItemOrder(){
        return itemOrder;
    }

    public void isAlive(){
        if (mood<0){
            System.out.println("Sim anda mati karena depresi");
        }
        else if(health<0){
            System.out.println("Sim anda mati karena sakit");
        }
        else if(fullness<0){
            System.out.println("Sim anda mati karena kelaparan");
        }
    }

    public void resetSim(){
        if (dailyPay<2){
            dailyPay++;
        }
        dailySleep=0;

    }

    class InputActionException extends Exception {
        public InputActionException(String s)
        {
            // Call constructor of parent Exception
            super(s);
        }
    }

    class StatusException extends Exception {
        public StatusException(String s)
        {
            // Call constructor of parent Exception
            super(s);
        }
    }
    //

    

    public void work(int time) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%30==0){
                            setMood(mood-10);
                            setFullness(fullness-10);
                            System.out.println("mood berkurang sebesar 10");
                            System.out.println("fullnes berkurang sebesar 10");
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                if (dailyWork>=240 && dailyPay > 0){
                    dailyWork=0;
                    dailyPay--;
                    System.out.println("uang bertambah sebesar " + job.getDailyPay());
                }
                world.runTime(time);
                isAlive();
            }
    
        });

        T.start();
        T.join();
    }

    //
    public void workout(int time) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%20==0){
                            setHeath(health+5);
                            setMood(mood+10);
                            setFullness(fullness-5);
                            System.out.println("mood dan health bertambah masing-masing 10 dan 5");
                            System.out.println("fullnes berkurang sebesar 5");
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                world.runTime(time);
                isAlive();
            }
    
        });

        T.start();
        T.join();


        
    }

    public void sleep(int time) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        dailySleep++;
                        if (dailySleep%240==0){
                            setMood(mood+30);
                            setHeath(health+20);
                            System.out.println("mood dan health bertambah masing-masing sebesar 30 dan 20" );
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                world.runTime(time);
                isAlive();


            }
    
        });

        T.start();
        T.join();
    }

    public void eat(Edible food,Inventory<Dish> inventorydish, Inventory<Food> inventoryfood) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = 29; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);

                        }catch(Exception e){
                            
                        }
                      
                             
                }
                setFullness(fullness+food.getFullness());
                System.out.println("fullness bertambah sebesar " + food.getFullness());
                afterEating = true;

                        if (food.getClass().getName().equals("Dish")){
                            Dish temp = (Dish) food;
                            try {
                                inventorydish.reduceInventory(temp);
                            } catch (Exception e) {
                                
                            }
                        }
                        else{
                            Food temp = (Food) food;
                            inventoryfood.addInventory(temp);
                        }   
                        world.runTime(30);
                        isAlive();
            }
    
        });

        T.start();
        T.join();

         
    }

    public void cook(Dish food,Inventory<Dish> inventorydish, Inventory<Food> inventoryfood) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (double i = food.getTime()-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        
                        }catch(Exception e){
                            
                        }

                    
                }
                setMood(mood+10);
                System.out.println("mood bertambah sebesar 10 dan masakan ditambahkan kedalam inventory");
                inventorydish.addInventory(food);
                for (String foods:food.getIngredient()){
                
                    try {
                        inventoryfood.reduceInventory(new Food(foods));
                    } catch (Exception e) {

                    }
                }
                world.runTime((int)food.getTime());
                isAlive();               
            }
    
        });
        T.start();
        T.join();

    }

    public void visit(House house) throws InterruptedException{
        double jarak = Math.sqrt((house.getCoordinate().getX()-this.house.getCoordinate().getX())^2 + (house.getCoordinate().getY()-this.house.getCoordinate().getY())^2);
        
        Thread perjalanan = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                System.out.println("Estimasi perjalanan adalah " + jarak + " detik");
                        try{
                        Thread.sleep((long)jarak*1000);
                        
                        }catch(Exception e){
                            
                        }

                    currentHouse = house;
                    berkunjung++;
                    System.out.println("Sudah sampai di tujuan");
                }
        });
        perjalanan.start();
        perjalanan.join();
        isAlive();
    }

    public void goHome() throws InterruptedException{
        double jarak = Math.sqrt((house.getCoordinate().getX()-this.house.getCoordinate().getX())^2 + (house.getCoordinate().getY()-this.house.getCoordinate().getY())^2);
        
        Thread perjalanan = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                System.out.println("Estimasi perjalanan adalah " + jarak + " detik");
                        try{
                        Thread.sleep((long)jarak*1000);
                        
                        }catch(Exception e){
                            
                        }

                    currentHouse = house;
                    berkunjung=0;
                    System.out.println("Sudah sampai di tujuan");
                }
        });
        perjalanan.start();
        perjalanan.join();
        isAlive();
    }

    public void defecate() throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = 10-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        
                        }catch(Exception e){
                            
                        }
                        
    
                }
                mood+=10;
                fullness-=20;
                System.out.println("mood bertambah sebesar 10");
                System.out.println("mood berkurang sebesar 20");
                afterEating = false;
                world.runTime(10);
                isAlive();

            }
    
        });
        T.start();
        T.join();
    }


//aksi tambahan 
//Saran tambahan aksi
//1. nonton tv (efek : +10 moood, -5 kesehatan, -5 kekenyanga/30 detik)
//2. Scroll SimTok (efek: +10 mood/30 detik, -5 kekenyangan/30 detik)
//3. Beribadah (efek: +5 mood/10 detik, -5 kekenyangan/10 detik)
//4. Mandi (efek: +10 mood/15 detik, -10 kekenyangan/15 detik, +10 kesehatan/15 detik )
//5. berenang (efek + 10 mood/30 detik , +10 healt/30detik, -15 fullnes/30 detik)
//6. bermain game (efek +20mood -10 health -10 fullness/20 detik)

    public void watchingTV(int time) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%30==0){
                            health-=5;
                            mood+=10;
                            fullness-=5;
                            System.out.println("mood bertambah sebesar 10");
                            System.out.println("health dan fullnes berkurang sebesar 5");

                        }
                        }catch(Exception e){
                            
                        }
    
                }
                world.runTime(time);
                isAlive();
            }
    
        });

        T.start();
        T.join();

        
       
    }

    public void scrollTiktok(int time) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%30==0){
                            mood+=10;
                            health-=5;
                            System.out.println("mood bertambah sebesar 10");
                            System.out.println("health berkurang sebesar 5");
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                world.runTime(time);
                isAlive();
            }
    
        });

        T.start();
        T.join();
    }

    public void beribadah(int time) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%10==0){
                            mood+=5;
                            fullness-=5;
                            System.out.println("mood bertambah sebesar 5");
                            System.out.println("fullness berkurang sebesar 5");
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                world.runTime(time);
                isAlive();
            }
    
        });

        T.start();
        T.join();
    }
    
    public void takeShower(int time) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%15==0){
                            mood+=10;
                            fullness-=10;
                            health+=10;
                            System.out.println("mood dan health bertambah sebesar 10");
                            System.out.println("fullness berkurang sebesar 10");
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                world.runTime(time);
                isAlive();
            }
    
        });

        T.start();
        T.join();
    }


    public void swiming(int time) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%30==0){
                            mood+=10;
                            fullness-=15;
                            health+=10;
                            System.out.println("mood dan health bertambah sebesar 10");
                            System.out.println("fullness berkurang sebesar 15");
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                world.runTime(time);
                isAlive();
            }
    
        });

        T.start();
        T.join();
    }

    public void playingGame(int time) throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%20==0){
                            mood+=20;
                            fullness-=10;
                            health-=10;
                            System.out.println("mood bertambah sebesar 20");
                            System.out.println("fullness dan health berkurang sebesar 10");
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                world.runTime(time);
                isAlive();
            }
    
        });

        T.start();
        T.join();
    }

    public void cleaningHouse() throws InterruptedException{
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = 20-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%15==0){
                            mood+=10;
                            fullness-=10;
                            health+=5;
                            System.out.println("mood dan health bertambah sebesar masing-masing 10 dan 5");
                            System.out.println("fullness berkurang sebesar 10");
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                world.runTime(20);
                isAlive();
            }
    
        });

        T.start();
        T.join();
    }

    public void timeFormat(int time){
        int menit = (time/60);
        int detik = (time)%60;
        if (menit<10 && detik<10){
            System.out.println("0" + menit + ":0" + detik );
        }
        else if (menit<10){
            System.out.println("0" + menit + ":" + detik );
        }
        else if (detik<10){
            System.out.println(menit + ":0" + detik );
        }
        else {
            System.out.println(menit + ":" + detik );
        }
    }

    public void viewClock(){
        System.out.print("Sisa waktu hari ini : ");
        timeFormat(720-world.getTime());
        
        
    }

    public void viewSimInfo(){
        System.out.println("        Info SIM");
        System.out.println("============================");
        System.out.println("Nama         : " + name);
        System.out.println("Pekerjaan    : " + job.getJobName());
        System.out.println("Gaji         : " + job.getDailyPay() + "/hari");
        System.out.println("Kesehatan    : " + health);
        System.out.println("Kekenyangan  : " + fullness);
        System.out.println("Mood         : " + mood);
        System.out.println("Uang         : " + mood);
        if (house.getUpgradeHouseTime()!=0){
            System.out.println("\n\nSisa Waktu upgrade rumah : ");
            timeFormat(house.getUpgradeHouseTime());
        }
        if (foodOrder!=null || itemOrder!= null){
            System.out.println("\n\nPesanan barang : ");
            for (Pair<String,Integer,Integer> pair : itemOrder){
                System.out.print(pair.getB() + " buah " + pair.getA() + " : ");
                timeFormat(pair.getC());
            }
            for (Pair<String,Integer,Integer> pair : foodOrder){
                System.out.print(pair.getB() + " buah " + pair.getA() + " : ");
                timeFormat(pair.getC());
            }
        }
    }

    public void viewCurrentLocation(){
        if (isBerkunjung){
        System.out.print("Anda sedang berada di rumah " + currentHouse.getSimName() + ", ");
    }   else{
        System.out.print("Anda sedang berada di rumah anda sendiri, ");
    }
    System.out.println("di ruangan " + currentRoom.getRoomName());
    currentRoom.printSpace();

    }

    
}
