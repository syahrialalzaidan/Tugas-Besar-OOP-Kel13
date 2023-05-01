

public class Sim{
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



    public Sim(String name,House house, World world){
        this.name = name;
        this.job = new Job("Badut Sulap");
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
    }

    public void setHeath(int health){
        this.health =  health;
        if (this.health>100){
            this.health = 100;
        }
    }

    public void setFullness(int fullness){
        this.fullness = fullness;
        if (this.fullness>100){
            this.fullness = 100;
        }
    }

    public void setKebelet(int kebelet){
        this.kebelet = kebelet;
    }

    public void setHouse(House house){
        this.house = house;
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

    

    public void work(int time){
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%30==0){
                            setMood(mood-10);
                            setFullness(fullness-10);
                        }
                        }catch(Exception e){
                            
                        }
    
                }
                if (dailyWork>=240 && dailyPay > 0){
                    dailyWork=0;
                    dailyPay--;
                }
            }
    
        });

        T.start();
    }

    //
    public void workout(int time){
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
                        }
                        }catch(Exception e){
                            
                        }
    
                }
            }
    
        });

        T.start();



        
    }

    public void sleep(int time){
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
                        }
                        }catch(Exception e){
                            
                        }
    
                }


            }
    
        });

        T.start();
    }

    public void eat(Edible food,Inventory<Dish> inventorydish, Inventory<Food> inventoryfood){
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

            }
    
        });

        T.start();

         
    }

    public void cook(Dish food,Inventory<Dish> inventorydish, Inventory<Food> inventoryfood){
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (double i = food.getTime(); i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        
                        }catch(Exception e){
                            
                        }

                    
                }
                setMood(mood+10);
                inventorydish.addInventory(food);
                for (String foods:food.getIngredient()){
                
                    try {
                        inventoryfood.reduceInventory(new Food(foods));
                    } catch (Exception e) {

                    }
                }                
            }
    
        });
        T.start();

    }

    public void visit(House house){

    }


    public void defecate(){
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
                afterEating = false;


            }
    
        });
        T.start();
    }


//aksi tambahan 
//Saran tambahan aksi
//2. nonton tv (efek : +10 moood, -5 kesehatan, -5 kekenyanga/30 detik)
//3. Scroll SimTok (efek: +10 mood/30 detik, -5 kekenyangan/30 detik)
//4. Beribadah (efek: +5 mood/10 detik, -5 kekenyangan/10 detik)
//6. Mandi (efek: +8 mood/15 detik, -10 kekenyangan/15 detik, +10 kesehatan/15 detik )
//7. berenang (efek + 10 mood/30 detik , +10 healt/30detik, -15 fullnes/30 detik)
//8. bermain game (efek +20mood -10 health -10 fullness/20 detik)

    public void watchingTV(int time){
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
                        }
                        }catch(Exception e){
                            
                        }
    
                }
            }
    
        });

        T.start();
       
    }

    public void scrollTiktok(int time){
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%30==0){
                            mood+=10;
                            health-=5;
                        }
                        }catch(Exception e){
                            
                        }
    
                }
            }
    
        });

        T.start();
    }

    public void beribadah(int time){
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%10==0){
                            mood+=5;
                            fullness-=5;
                        }
                        }catch(Exception e){
                            
                        }
    
                }
            }
    
        });

        T.start();
    }
    
    public void takeShower(int time){
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
                        }
                        }catch(Exception e){
                            
                        }
    
                }
            }
    
        });

        T.start();
    }


    public void swiming(int time){
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
                        }
                        }catch(Exception e){
                            
                        }
    
                }
            }
    
        });

        T.start();
    }

    public void playingGame(int time){
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = time-1; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                        if (i%20==0){
                            mood+=10;
                            fullness-=15;
                            health+=10;
                        }
                        }catch(Exception e){
                            
                        }
    
                }
            }
    
        });

        T.start();
    }

    public void viewClock(){
        System.out.println("Sisa waktu hari ini adalah");
        System.out.println(world.getTime());
    }

    
}