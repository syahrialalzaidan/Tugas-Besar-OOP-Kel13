


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
    private int ngantuk;
    private int kebelet;
    private boolean afterEating;
    private int dailyWork;
    private int dailySleep;
    private int dailyPay;



    public Sim(String name, World world){
        this.name = name;
        this.job = new Job();
        this.world = world;
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

    
    
    public void setName(String name){
        this.name = name;
    }

    public void setJob(Job job){
        this.job = job;
    }

    public void setMoney(int money){
        this.money = money;
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
                            mood-=10;
                            fullness-=10;
                        }
                        }catch(Exception e){
                            
                        }
    
                }
            }
    
        });

        try{
            if (time%30!=0){
                throw new InputActionException("Input waktu adalah kelipatan 30 detik");
            }
            if ((time/30)*10>fullness || (time/30)*10>mood){
                throw new StatusException("Atribut kekenyangan anda tidak cukup untuk melakukan kerja selama " + time + " detik.");
            }
            else{
                T.start();
            }
        }catch(StatusException | InputActionException e){
            System.out.println(e.getMessage());
        }
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
                            health+=5;
                            mood+=10;
                            fullness-=5;
                        }
                        }catch(Exception e){
                            
                        }
    
                }
            }
    
        });

        try{
            if (time%20!=0){
                throw new InputActionException("Input waktu adalah kelipatan 20 detik");
            }
            if ((time/20)*5>fullness){
                throw new StatusException("Atribut kekenyangan anda tidak cukup untuk melakukan olahraga selama " + time + " detik.");
            }
            else{
                T.start();
            }
        }catch(StatusException | InputActionException e){
            System.out.println(e.getMessage());
        }



        
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
                            mood+=30;
                            health+=20;
                        }
                        }catch(Exception e){
                            
                        }
    
                }


            }
    
        });

        try{
            if (time%180!=0){
                throw new InputActionException("Input waktu adalah kelipatan 180 detik atau 3 menit");
            }

            else{
                T.start();
            }
        }catch(InputActionException e){
            System.out.println(e.getMessage());
        }
    }

    public void eat(Edible food,Inventory<Dish> inventorydish, Inventory<Food> inventoryfood){
        Thread T = new Thread(new Runnable(){
        
            @Override 
            public void run(){
                for (int i = 29; i >=0 ;i--){
                        try{
                        Thread.sleep(1000);
                
                        }catch(Exception e){
                            
                        }finally{
                            fullness+=food.getFullness();
                            afterEating = true;
                            if (food.getClass().getName().equals("Dish")){
                                inventorydish.reduceInventory(food);
                            }
                            else{
                                inventoryfood.reduceInventory(food);
                            }
                        }
                        
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
                            
                        }finally{
                            mood+=10;
                            inventorydish.addInventory(food);
                            for (String foods:food.getIngredient()){
                                inventoryfood.reduceInventory(new Food(foods));
                            }
                        }
    
                }


            }
    
        });
        boolean check = true;
        for (String foods: food.getIngredient()){
            if (!inventoryfood.getInventory().containsKey(new Food(foods))){
                check = false;
            }
        }
        if (check){
            T.start();
        }
        else {
            System.out.println("Bahan makanan tidak cukup untuk memasak");
        }


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
                            
                        }finally{
                            mood+=10;
                            fullness-=20;
                            afterEating = false;
                        }
    
                }


            }
    
        });
        try{
            if (fullness<20){
                throw new InputActionException("Anda terlalu lapar untuk buah air");
            }
            else{
                T.start();
            }
        }catch(InputActionException e){
            System.out.println(e.getMessage());
        }
    }
}