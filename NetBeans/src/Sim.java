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
    private int workTime;
    private House currentHouse;
    private boolean alive;
    private int berkunjung;
    private boolean isBerkunjung;
    private Room currentRoom;
    private Items currentItems;
    private Point simPoint;
    private List<Pair<String,Integer,Integer>> itemOrder = new ArrayList<Pair<String,Integer,Integer>>();
    private List<Pair<String,Integer,Integer>> foodOrder = new ArrayList<Pair<String,Integer,Integer>>();


    public Sim(String name,House house, World world){
        Random rand = new Random();
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
        this.simPoint = new Point(0,0);

        Items item1 = new Items("Kasur Single");
        Items item2 = new Items("Toilet");
        Items item3 = new Items("Kompor Gas");
        Items item4 = new Items("Jam");
        Items item5 = new Items("Meja dan Kursi");

        addInventoryitems(item1);
        addInventoryitems(item2);
        addInventoryitems(item3);
        addInventoryitems(item4);
        addInventoryitems(item5);

        // Memasukan House ke dalam World
        world.addHouse(house);
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
    
    public int getWorkTime(){
        return workTime;
    }

    public Point getSimPoint(){
        return simPoint;
    }

    public void setSimPoint(int x , int y){
        simPoint.setX(x);
        simPoint.setY(y);
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
        if (this.mood<=0){
            alive = false;
        }
    }

    public void setHeath(int health){
        this.health =  health;
        if (this.health>100){
            this.health = 100;
        }
        if (this.health<=0){
            alive = false;
        }
    }

    public void setFullness(int fullness){
        this.fullness = fullness;
        if (this.fullness>100){
            this.fullness = 100;
        }
        if (this.fullness<=0){
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

    public void setWorkTime(int time){
        workTime = time;
    }

    public void setDailyWork(int time){
        this.dailyWork = time;
    }
    
    public void setBerkunjung(int berkunjung){
        this.berkunjung = berkunjung;
    }

    public void setCurrentItems(Items items){
        currentItems = items;
    }
    
    public void setJob(Job job){
        this.job = job;
    }


    public void addItemOrder(String A, int B, int C){
        itemOrder.add(new Pair<>(A,B,C));

    }

    public void addFoodOrder(String A, int B, int C){
        foodOrder.add(new Pair<>(A,B,C));

    }

    public void removeItemOrder(int i){
        itemOrder.remove(i);
    }

    public void removeFoodOrder(int i){
        foodOrder.remove(i);
    }
    public List<Pair<String,Integer,Integer>> getFoodOrder(){
        return foodOrder;
    }

    public List<Pair<String,Integer,Integer>> getItemOrder(){
        return itemOrder;
    }

    public void isAlive(){
        if (mood<=0){
            System.out.println("Sim anda mati karena depresi");
        }
        else if(health<=0){
            System.out.println("Sim anda mati karena sakit");
        }
        else if(fullness<=0){
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
                System.out.println("SIM sedang bekerja....");
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
                        if (i%30==0){
                            setMood(mood-10);
                            setFullness(fullness-10);
                            System.out.println("mood berkurang sebesar 10");
                            System.out.println("fullnes berkurang sebesar 10");
                            dailyWork+=30;
                            workTime+=30;
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                if (dailyWork>=240 && dailyPay > 0){
                    dailyWork=0;
                    dailyPay--;
                    System.out.println("uang bertambah sebesar " + job.getDailyPay());
                    money+= job.getDailyPay();
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
                System.out.println("SIM sedang berolahraga....");
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
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
                System.out.println("SIM sedang tidur....");
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
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
                if (time>world.getTime()){
                    dailySleep=(time-world.getTime());
                }
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
                System.out.println("SIM sedang makan....");
                for (int i = 29; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);

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
                            try {
                                inventoryfood.reduceInventory(temp);
                            } catch (Exception e) {

                            }
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
                System.out.println("SIM sedang memasak....");
                for (double i = food.getTime()-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
                        
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
        double jarak = Math.sqrt(Math.abs((house.getCoordinate().getX()-this.house.getCoordinate().getX())^2 + (house.getCoordinate().getY()-this.house.getCoordinate().getY())^2));
        
        Thread perjalanan = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                
                System.out.println("Estimasi perjalanan adalah " + jarak + " detik");
                        try{
                        Thread.sleep((long)jarak*1000);
                        System.out.println("Countdown = " + jarak);
                        
                        }catch(Exception e){
                            
                        }

                    currentHouse = house;
                    berkunjung++;
                    isBerkunjung = true;
                    currentItems = null;
                    currentRoom = house.getRoom(0);
                    System.out.println("Sudah sampai di tujuan");
                }
        });
        perjalanan.start();
        perjalanan.join();
        isAlive();
    } 

    public void goHome() throws InterruptedException{
        double jarak = Math.sqrt(Math.abs((house.getCoordinate().getX()-this.house.getCoordinate().getX())^2 + (house.getCoordinate().getY()-this.house.getCoordinate().getY())^2));
        
        Thread perjalanan = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                System.out.println("Estimasi perjalanan adalah " + jarak + " detik");
                        try{
                        Thread.sleep((long)jarak*1000);
                        System.out.println("Countdown = " + jarak);
                        
                        }catch(Exception e){
                            
                        }

                    currentHouse = house;
                    berkunjung=0;
                    isBerkunjung = false;
                    currentItems = null;
                    currentRoom = house.getRoom(0);
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
                System.out.println("SIM sedang baung air....");
                for (int i = 10-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
                        
                        }catch(Exception e){
                            
                        }
                        
    
                }
                setMood(mood+10);
                setFullness(fullness-20);
                System.out.println("mood bertambah sebesar 10");
                System.out.println("fullness berkurang sebesar 20");
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
                System.out.println("SIM sedang nonton tv....");
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
                        if (i%30==0){
                            setHeath(health-5);
                            setMood(mood+10);
                            setFullness(fullness-5); ;
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
                System.out.println("SIM sedang scroll tiktok....");
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
                        if (i%30==0){
                            setMood(mood+10);
                            setHeath(health-5);
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
                System.out.println("SIM sedang solat....");
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
                        if (i%10==0){
                            setMood(mood+5);
                            setFullness(fullness-5);
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
                System.out.println("SIM sedang mandi....");
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
                        if (i%15==0){
                            setMood(mood+10);
                            setFullness(fullness-10); 
                            setHeath(health+10); 
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
                System.out.println("SIM sedang berenang....");
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
                        if (i%30==0){
                            setMood(mood+10);
                            setFullness(fullness-15); 
                            setHeath(health+10); 
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
                System.out.println("SIM sedang bermain valorant....");
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
                        if (i%20==0){
                            setMood(mood+20);   
                            setFullness(fullness-10); 
                            setHeath(health-10);
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
                System.out.println("SIM sedang beres-beres rumah....");
                for (int i = 20-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        System.out.println("Countdown = " + i);
                        if (i%15==0){
                            setMood(mood+10); 
                            setFullness(fullness-10); 
                            setHeath(health+5); 
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
        System.out.println("Hari ke-"+ world.getDay() );
        System.out.println("Nama         : " + name);
        System.out.println("Pekerjaan    : " + job.getJobName());
        System.out.println("Gaji         : " + job.getDailyPay() + "/hari");
        System.out.println("Kesehatan    : " + health);
        System.out.println("Kekenyangan  : " + fullness);
        System.out.println("Mood         : " + mood);
        System.out.println("Uang         : " + money);
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

    public void chooseAction(String aksi) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        switch (aksi) {
            case "Toilet":

                defecate();
                break;
            case "TV":

                boolean check1 = false;
                while (!check1) {
                    try {
                        System.out.print("Masukkan waktu input (Kelipatan 30) : ");
                        int inputTime = input.nextInt();
                        if (inputTime % 30 != 0) {
                            check1 = false;
                            System.out.println("Masukkan waktu harus keliapatan 30 detik");
                        } else {
                            check1 = true;
                            watchingTV(inputTime);
                        }
                    } catch (Exception e) {
                        System.out.println("Input harus berupa angka");
                        System.out.println("Silakan masukan input ulang");
                        System.out.println("");
                        input.nextLine();
                    }
                }
                break;
            case "Komputer":
                boolean check2 = false;
                while (!check2) {
                    try {
                        System.out.print("Masukkan waktu input (Kelipatan 20) : ");
                        int inputTime = input.nextInt();
                        if (inputTime % 20 != 0) {
                            check2 = false;
                            System.out.println("Masukkan waktu harus keliapatan 20 detik");
                        } else {
                            check2 = true;
                            playingGame(inputTime);

                        }
                    } catch (Exception e) {
                        System.out.println("Input harus berupa angka");
                        System.out.println("Silakan masukan input ulang");
                        System.out.println("");
                        input.nextLine();
                    }
                }

                break;
            case "Kolam Renang":
                boolean check3 = false;
                while (!check3) {
                    try {
                        System.out.print("Masukkan waktu input (Kelipatan 30 detik) : ");
                        int inputTime = input.nextInt();
                        if (inputTime % 30 != 0) {
                            check3 = false;
                            System.out.println("Masukkan waktu harus keliapatan 30 detik");
                        } else {
                            check3 = true;
                            swiming(inputTime);

                        }
                    } catch (Exception e) {
                        System.out.println("Input harus berupa angka");
                        System.out.println("Silakan masukan input ulang");
                        System.out.println("");
                        input.nextLine();
                    }
                }
                break;
            case "Shower":
                boolean check4 = false;
                while (!check4) {
                    try {
                        System.out.print("Masukkan waktu input (Kelipatan 15 detik) : ");
                        int inputTime = input.nextInt();
                        if (inputTime % 15 != 0) {
                            check4 = false;
                            System.out.println("Masukkan waktu harus keliapatan 15 detik");
                        } else {
                            check4 = true;
                            takeShower(inputTime);

                        }
                    } catch (Exception e) {
                        System.out.println("Input harus berupa angka");
                        System.out.println("Silakan masukan input ulang");
                        System.out.println("");
                        input.nextLine();
                    }
                }
                break;
            case "Jam":
                viewClock();
                break;
            case "Meja dan Kursi":

                if (inventorydish.getInventory().size()!=0 || inventoryfood.getInventory().size()!=0){
                getInventoryfood().printInventory();
                getInventorydish().printInventory();
                boolean check = true;
                while (check) {
                    System.out.print("Pilih makanan untuk dimakan : ");
                    String inputMakanan = input.nextLine();
                    if (getInventoryfood().getInventory()
                            .containsKey(inputMakanan)) {
                        eat(new Food(inputMakanan), getInventorydish(),
                                getInventoryfood());
                        check = false;
                    } else if (getInventorydish().getInventory()
                            .containsKey(inputMakanan)) {
                        eat(new Dish(inputMakanan), getInventorydish(),
                                getInventoryfood());
                    } else {
                        System.out.println(
                                "Kamu tidak memiliki makanan tersebut di inventory, mohon masukkan kembali makanan yang ingin dimakan");
                    }
                }}
                break;
            case "Kompor Gas":
                boolean check6 = true;
                System.out.println("Pilih makanan yang ingin dimasak");
                System.out.println("1. Nasi Ayam      | Membutuhkan Nasi dan Ayam");
                System.out.println("2. Nasi Kari      | Membutuhkan Nasi, Kentang, Wortel, dan Sapi");
                System.out.println("3. Susu Kacang    | Membutuhkan Susu dan Kacang");
                System.out.println("4. Tumis Sayur    | Membutuhkan Wortel dan Bayam");
                System.out.println("5. Bistik         | Membutuhkan Sapi dan Kentang");
                boolean Makanan = false;
                while(!Makanan){
                    System.out.print("Masukkan nama masakan yang ingin dimasak : ");
                    String masakan = input.nextLine();  
                    if (masakan.equals("Nasi Ayam")||masakan.equals("Nasi Kari")||
                    masakan.equals("Susu Kacang")||masakan.equals("Tumis Sayur")||masakan.equals("Bistik")) {
                        Dish dish = new Dish(masakan);
                        for (String foods : dish.getIngredient()) {
                            if (!getInventoryfood().getInventory().containsKey(foods)) {
                                check6 = false;
                            }
                        }
                        if (check6) {
                            cook(dish, getInventorydish(),
                                    getInventoryfood());
                        } else {
                            System.out.println("Bahan makanan tidak cukup untuk memasak");
                        }
                        Makanan = true;
                    }                  
                    else{
                        System.out.println("Input masakan salah, masukkan nama masakan kembali");
                    }               
                }

                break;
            case "Kompor Listrik":
            boolean check5 = true;
            System.out.println("Pilih makanan yang ingin dimasak");
            System.out.println("1. Nasi Ayam      | Membutuhkan Nasi dan Ayam");
            System.out.println("2. Nasi Kari      | Membutuhkan Nasi, Kentang, Wortel, dan Sapi");
            System.out.println("3. Susu Kacang    | Membutuhkan Susu dan Kacang");
            System.out.println("4. Tumis Sayur    | Membutuhkan Wortel dan Bayam");
            System.out.println("5. Bistik         | Membutuhkan Sapi dan Kentang");
            boolean Makanan1 = false;
            input.close();
            while(!Makanan1){
                System.out.print("Masukkan nama masakan yang ingin dimasak : ");
                String masakan = input.nextLine();  
                if (masakan.equals("Nasi Ayam")||masakan.equals("Nasi Kari")||
                masakan.equals("Susu Kacang")||masakan.equals("Tumis Sayur")||masakan.equals("Bistik")) {
                    Dish dish = new Dish(masakan);
                    for (String foods : dish.getIngredient()) {
                        if (!getInventoryfood().getInventory().containsKey(foods)) {
                            check5 = false;
                        }
                    }
                    if (check5) {
                        cook(dish, getInventorydish(),
                                getInventoryfood());
                    } else {
                        System.out.println("Bahan makanan tidak cukup untuk memasak");
                    }
                    Makanan1 = true;
                }                  
                else{
                    System.out.println("Input masakan salah, masukkan nama masakan kembali");
                }               
            }

            break;
            case "Sapu":
                cleaningHouse();
                break;
            case "Sajadah":
            boolean checkSajadah = false;
            while (!checkSajadah) {
                try {
                    System.out.print("Masukkan waktu input (Kelipatan 10) : ");
                    int inputTime = input.nextInt();
                    if (inputTime % 10 != 0) {
                        checkSajadah = false;
                        System.out.println("Masukkan waktu harus keliapatan 10 detik");
                    } else {
                        checkSajadah = true;
                        beribadah(inputTime);

                    }
                } catch (Exception e) {
                    System.out.println("Input harus berupa angka");
                    System.out.println("Silakan masukan input ulang");
                    System.out.println("");
                    input.nextLine();
                }
            }
            break;
            case "HP":
            boolean checkHP = false;
            while (!checkHP) {
                try {
                    System.out.print("Masukkan waktu input (Kelipatan 30) : ");
                    int inputTime = input.nextInt();
                    if (inputTime % 30 != 0) {
                        checkHP = false;
                        System.out.println("Masukkan waktu harus kelipatan 30 detik");
                    } else {
                        checkHP = true;
                        scrollTiktok(inputTime);

                    }
                } catch (Exception e) {
                    System.out.println("Input harus berupa angka");
                    System.out.println("Silakan masukan input ulang");
                    System.out.println("");
                    input.nextLine();
                }
            }
            break;
            default:
                boolean checkTidur = false;
                while(!checkTidur){
                try {
                    System.out.print("Masukan waktu input (Kelipatan 180) : ");
                    int waktuTidur = input.nextInt();
                    if (waktuTidur % 180 == 0) { // Cek apakah angka merupakan kelipatan 180
                        sleep(waktuTidur);
                        checkTidur = true;
                    } else {
                        System.out.println("Input harus kelipatan 180.");
                    }
                } catch (Exception e) {
                    System.out.println("Input harus berupa angka");
                    System.out.println("Silakan masukan input ulang");
                    System.out.println("");
                    input.nextLine();
                }   
            }
                
        }
    }



    
}
