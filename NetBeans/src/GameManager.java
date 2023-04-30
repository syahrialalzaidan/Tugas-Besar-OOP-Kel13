import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.util.*;
import java.util.Map.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    private static List<Sim> simList = new ArrayList<>();
    private Sim sim;

    public static void addSim(String nama, List<Sim> simList) {
        Sim sim = new Sim(nama);
        simList.add(sim);
    }

    public List<Sim> getSimList(){
        return simList;
    }

    public static void changeSim(String nama) {
        Sim sim = null;
        for (Sim s : simList) {
            if (s.getName().equals(nama)) {
                sim = s;
                break;
            }
        }
    }

    public static void printActionMenu() {
        System.out.println("Menu: ");
        System.out.println("1.View Sim Info");
        System.out.println("2.View Current Location");
        System.out.println("3.View Inventory");
        System.out.println("4.Upgrade House");
        System.out.println("5.Move Room");
        System.out.println("6.Edit Room");
        System.out.println("7.Add Sim");
        System.out.println("8.Change Sim");
        System.out.println("9.List Object");
        System.out.println("10.Go To Object");
        System.out.println("11.Action");
        System.out.println("12.Exit");
        System.out.println("");
        System.out.println("action: ");
        System.out.println("13.Beli barang");
        System.out.println("14.Memasang barang");
        System.out.println("");
    }

    public static void help() {
        // Isi Help Disini
        // ---------------
    }

    public static void exit() {
        // Isi Exit Disini
        // ---------------
    }

    public static void main(String[] args) throws Exception {
        List<Sim> simList = new ArrayList<>();
        Sim currentSim;
        World world;
        House currentHouse;
        Room currentRoom;
        int upgradeHouse = 0;

        Scanner input = new Scanner(System.in);

        // Welcome Page is Here
        // --------------------

        // Menu Option pertama
        System.out.println("");
        System.out.println("Pilihlah Salah Satu Menu Dibawah ini: ");
        System.out.println("1. Start New Game");
        /* System.out.println("2. Load Game"); */
        System.out.println("2. Help");
        System.out.println("3. Exit");

        Boolean validInput = false;
        while (!validInput) {
            // Masukan Pilihan
            System.out.print("Masukkan Pilihan Anda: ");
            String pilihan = input.nextLine();

            if (pilihan.equals("1") || pilihan.equalsIgnoreCase("Start New Game")) {
                // Start New Game
                System.out.println("Masukkan Nama Sim: ");
                String namaSim = input.nextLine();
                world = new World();

                // Random Posisi Rumah Pertama
                int max = 63;
                int min = 0;
                int x = (int) (Math.random() * (max - min + 1) + min);
                int y = (int) (Math.random() * (max - min + 1) + min);

                Point coordinate = new Point(x, y);
                House firstHouse = new House(coordinate);

                // membuat Sim pertama
                Sim firstSim = new Sim(namaSim);
                
                // Memasukan Sim kedalam SimList
                addSim(namaSim, simList);

                // currentSim mengacu ke firstSim
                currentSim = simList.get(0);

                // Memasukan House ke dalam World
                world.addHouse(currentSim.getHouse());
                currentHouse = currentSim.getHouse();
                currentRoom = currentHouse.getRoom();
                validInput = true;
            } else if (pilihan.equals("2") || pilihan.equalsIgnoreCase("Help")) {
                // Help
                help();
                validInput = true;
            } else if (pilihan.equals("3") || pilihan.equalsIgnoreCase("Exit")) {
                // Exit
                exit();
                validInput = true;
            } else {
                // Invalid Input
                System.out.println("Invalid Input");
            }
        }

        System.out.println("Selamat datang " + currentSim.getName() + "di dunia SIM!");
        System.out.println("");

        for (int i = 0; i < 4; i++) {
            System.out.print("\rHold on , we are Generating Sims Map . . . . . ");
            Thread.sleep(1000);
            System.out.print("\r                                 ");
            Thread.sleep(1000);
        }

        System.out.println("Map Generated!");
        System.out.println("Kamu Sekarang berada di " + currentRoom.getRoomName());
        currentRoom.printSpace();
        System.out.println("");

        printActionMenu();

        Boolean exit = false;
        Boolean simInHouse = true;
        while(!exit)
        {
            System.out.print("Masukan Pilihan Anda (Angka / Aksi): ");
            String actionMenuInput = input.nextLine();
            if(actionMenuInput.equals("1")|| actionMenuInput.equalsIgnoreCase("View Sim Info"))
            {
                // TODO: View Sim Info
            } else if (menuInput.equals("2") || menuInput.equalsIgnoreCase("View Current Location")) {
                // TODO: View Current Location
            } else if (menuInput.equals("3") || menuInput.equalsIgnoreCase("View Inventory")) {
                // TODO: View Inventory
                System.out.println("INVENTORY of " + currentSim.getName());
                System.out.println("=============================");
                currentSim.getInventoryfood().printInventory();
                System.out.println(" ");
                System.out.println(" ");
                currentSim.getInventorydish().printInventory();
                System.out.println(" ");
                System.out.println(" ");
                currentSim.getInventoryitems().printInventory();

            } else if (menuInput.equals("4") || menuInput.equalsIgnoreCase("Upgrade House")) {
                // TODO: Upgrade House
                
                //Validasi apakah Sims berada didalam Rumah
                if(!simInHouse)
                {
                    System.out.println("Sim tidak berada didalam rumah");
                }

                //Validasi Uang Sim
                else if(currentSim.getMoney() < 1500)
                {
                    System.out.println("Uang tidak cukup");
                }

                else
                {
                    System.out.print("Masukan Nama Ruangan Baru: ");
                    String namaRumah = input.nextLine();

                    Room room = new Room(namaRumah);

                    Room[] rooms = currentHouse.getRooms();
                    for(int i = 0 ; i < currentHouse.getRoomsTotal() ; i++)
                    {
                        System.out.printf("%d. %s" , i+1 , rooms[i].getRoomName());
                        System.out.println("");
                    }

                    Boolean roomRootSet = false;
                    Room roomRoot = null;

                    while(!roomRootSet)
                    {
                        System.out.print("Masukan Ruangan yang akan dihubungkan: ");
                        String roomRootName = input.nextLine();

                        for(int i = 0 ; i < currentHouse.getRoomsTotal() ; i++)
                        {
                            if(rooms[i].getRoomName().equalsIgnoreCase(roomRootName))
                            {
                                roomRoot = rooms[i];
                            }
                        }

                        if(roomRoot == null)
                        {
                            System.out.println("Ruangan tidak ditemukan");
                        }
                        else
                        {
                            validInput = true;
                        }
                    }

                    System.out.println("Berikut adalah Ruangan yang terkoneksi dengan Ruangan " + roomRoot.getRoomName());
                    roomRoot.printAroundRoom();
                    System.out.println("");

                    // Check Apakah masih ada ruang yang bisa ditambahkan disekitar RoomRoot
                    if(roomRoot.checkAroundRoom())
                    {
                        System.out.print("Masukan Posisi Ruangan Baru (Up, Down , Right , Left): ");
                        String direction = input.nextLine();

                        while(!(direction.equalsIgnoreCase("Up") || direction.equalsIgnoreCase("Down") || direction.equalsIgnoreCase("Right") || direction.equalsIgnoreCase("Left")))
                        {
                            System.out.println("Posisi Ruangan tidak valid");
                            System.out.print("Masukan Posisi Ruangan Baru (Up, Down , Right , Left): ");
                            direction = input.nextLine();
                        }
                    
                    
                        Boolean isRoomSet = false;

                        while(!isRoomSet)
                        {                    
                            if(direction.equalsIgnoreCase("Up"))
                            {
                                if(roomRoot.getUpperRoom() != null)
                                {
                                    System.out.println("Room Sudah ada");
                                    System.out.println("The Room is : " + roomRoot.getUpperRoom().getRoomName());
                                }
                                else
                                {
                                    Timer T = new Timer();
                                    TimerTask UpgradeHouse = new TimerTask()
                                    {
                                        @Override
                                        public void run()
                                        {
                                            if(upgradeHouse < 1080)
                                            {
                                                upgradeHouse++;
                                            }
                                            else
                                            {
                                                roomRoot.setUpperRoom(room);
                                                room.setLowerRoom(roomRoot);
                                                isRoomSet = true;
                                                upgradeHouse = 0;
                                                System.out.println("Ruangan berhasil ditambahkan");
                                                T.cancel();
                                            }
                                        }
                                    };
                                    Calendar date = Calendar.getInstance();
                                    date.set(2021, Calendar.OCTOBER, 30,23, 59, 54);
                                    T.scheduleAtFixedRate(UpgradeHouse, date.getTime(), 1000);
                                }       
                                
                            }
                            else if(direction == "Down")
                            {
                                if(roomRoot.getLowerRoom() != null)
                                {
                                    System.out.println("Room Sudah ada");
                                    System.out.println("The Room is : " + roomRoot.getLowerRoom().getRoomName());
                                }
                                else
                                {
                                    Timer T = new Timer();
                                    TimerTask UpgradeHouse = new TimerTask()
                                    {
                                        @Override
                                        public void run()
                                        {
                                            if(upgradeHouse < 1080)
                                            {
                                                upgradeHouse++;
                                            }
                                            else
                                            {
                                                roomRoot.setLowerRoom(room);
                                                room.setUpperRoom(roomRoot);
                                                isRoomSet = true;
                                                upgradeHouse = 0;
                                                System.out.println("Ruangan berhasil ditambahkan");
                                                T.cancel();
                                            }
                                        }
                                    };
                                    Calendar date = Calendar.getInstance();
                                    date.set(2021, Calendar.OCTOBER, 30,23, 59, 54);
                                    T.scheduleAtFixedRate(UpgradeHouse, date.getTime(), 1000);
                                }
                            }
                            else if(direction == "Left")
                            {
                                if(roomRoot.getLeftRoom() != null)
                                {
                                    System.out.println("Room Sudah ada");
                                    System.out.println("The Room is : " + roomRoot.getLeftRoom().getRoomName());
                                }
                                else
                                {
                                    Timer T = new Timer();
                                    TimerTask UpgradeHouse = new TimerTask()
                                    {
                                        @Override
                                        public void run()
                                        {
                                            if(upgradeHouse < 1080)
                                            {
                                                upgradeHouse++;
                                            }
                                            else
                                            {
                                                roomRoot.setLeftRoom(room);
                                                room.setRightRoom(roomRoot);
                                                isRoomSet = true;
                                                upgradeHouse = 0;
                                                System.out.println("Ruangan berhasil ditambahkan");
                                                T.cancel();
                                            }
                                        }
                                    };
                                    Calendar date = Calendar.getInstance();
                                    date.set(2021, Calendar.OCTOBER, 30,23, 59, 54);
                                    T.scheduleAtFixedRate(UpgradeHouse, date.getTime(), 1000);
                                    
                                }
                            }
                            else if(direction == "Right")
                            {
                                if(roomRoot.getRightRoom() != null)
                                {
                                    System.out.println("Room Sudah ada");
                                    System.out.println("The Room is : " + roomRoot.getRightRoom().getRoomName());
                                }
                                else
                                {
                                    Timer T = new Timer();
                                    TimerTask UpgradeHouse = new TimerTask()
                                    {
                                        @Override
                                        public void run()
                                        {
                                            if(upgradeHouse < 1080)
                                            {
                                                upgradeHouse++;
                                            }
                                            else
                                            {
                                                roomRoot.setRightRoom(room);
                                                room.setLeftRoom(roomRoot);
                                                isRoomSet = true;
                                                upgradeHouse = 0;
                                                System.out.println("Ruangan berhasil ditambahkan");
                                                T.cancel();
                                            }
                                        }
                                    };
                                    Calendar date = Calendar.getInstance();
                                    date.set(2021, Calendar.OCTOBER, 30,23, 59, 54);
                                    T.scheduleAtFixedRate(UpgradeHouse, date.getTime(), 1000);
                                }
                            }
                            else
                            {
                                System.out.println("Invalid Direction");
                            }
                        }
                    }
                }
            }
            else if(actionMenuInput.equals("5")|| actionMenuInput.equalsIgnoreCase("Move Room"))
            {
                // TODO: Move Room
                 
                //Validasi apakah Sims berada didalam Rumah
                if(!simInHouse)
                {
                    System.out.println("Sim tidak berada didalam rumah");
                }

                Room[] listRooms = currentHouse.getRooms();
                System.out.println("Berikut adalah List Ruangan yang tersedia : ");
                for(int i = 0; i < currentHouse.getRoomsTotal(); i++)
                {
                    System.out.println((i+1) + ". " + listRooms[i].getRoomName());
                }
                System.out.println("");

                Boolean inputbenar = false;
                int roomindex;
                while(!inputbenar)
                {
                    System.out.print("Masukkan nama ruangan yang ingin dipindahkan : ");
                    String roomName = input.nextLine();
                    for(int i = 0; i < currentHouse.getRoomsTotal(); i++)
                    {
                        if(roomName.equalsIgnoreCase(listRooms[i].getRoomName()))
                        {
                            inputbenar = true;
                            roomindex = i;
                            break;
                        }
                    }
                    if(!inputbenar)
                    {
                        System.out.println("Ruangan tidak ditemukan");
                        System.out.println("Silakan masukan ruangan ulang");
                        System.out.println("");
                    }
                }

                currentRoom = currentHouse.getRoom(roomindex);
                System.out.println("Sim berhasil berpindah ke Ruangan " + currentRoom.getRoomName());
                System.out.println("");

                System.out.println(currentRoom.getRoomName());
                currentRoom.printSpace();
                System.out.println("");
            }

            else if(actionMenuInput.equals("6")|| actionMenuInput.equalsIgnoreCase("Edit Room"))
            {
                // TODO: Edit Room
                currentRoom.printSpace();
                System.out.println("");

                System.out.println("Berikut adalah List Object yang ada di " + currentRoom.getRoomName() + " : ");
                HashMap<Coordinate, Items> listItemInRoom = currentRoom.getObject();
                int i = 1;
                for(Coordinate coordinate: listItemInRoom.keySet())
                {
                    System.out.println(i + ". " + listItemInRoom.get(coordinate).getName() + " | Coordinate = " +" (" + coordinate.getX1() + "," + coordinate.getY1() + ")" + " - (" + coordinate.getX2() + "," + coordinate.getY2() + ")");
                    i++;
                }
                System.out.println("");

                Boolean inputbenar = false;

                Coordinate initialCoordinate;
                Items theItems;

                while(!inputbenar)
                {
                    System.out.print("Masukkan nama object yang ingin diubah : ");
                    String objectName = input.nextLine();

                    System.out.print("Masukan koordinat x1 : ");
                    int x1 = input.nextInt();
                    System.out.print("Masukan koordinat y1 : ");
                    int y1 = input.nextInt();


                    for(Coordinate coordinate: listItemInRoom.keySet())
                    {
                        if((objectName.equalsIgnoreCase(listItemInRoom.get(coordinate).getName())) && (x1 == coordinate.getX1()) && (y1 == coordinate.getY1()))
                        {
                            inputbenar = true;
                            initialCoordinate = coordinate;
                            theItems = listItemInRoom.get(coordinate);
                            break;
                        }
                    }

                    if(!inputbenar)
                    {
                        System.out.println("Object tidak ditemukan");
                        System.out.println("Silakan masukan object dan coordinate ulang");
                        System.out.println("");
                    }
                }

                currentRoom.moveObject(theItems, initialCoordinate);

                
            }
            else if(actionMenuInput.equals("7")|| actionMenuInput.equalsIgnoreCase("Add Sim"))
            {
                // TODO: Add Sim
            } else if (menuInput.equals("8") || menuInput.equalsIgnoreCase("Change Sim")) {
                // TODO: Change Sim
            } else if (menuInput.equals("9") || menuInput.equalsIgnoreCase("List Object")) {
                System.out.println("List of objects:");
                System.out.println("=====================");

                System.out.println("Items");
                System.out.println("1. Kasur Single");
                System.out.println("2. Kasur Queen Size");
                System.out.println("3. Kasur King Size");
                System.out.println("4. Toilet");
                System.out.println("5. Kompor Gas");
                System.out.println("6. Kompor Listrik");
                System.out.println("7. Meja dan Kursi");
                System.out.println("8. Jam");
                System.out.println("");

                System.out.println("Food");
                System.out.println("1. Nasi");
                System.out.println("2. Kentang");
                System.out.println("3. Ayam");
                System.out.println("4. Sapi");
                System.out.println("5. Wortel");
                System.out.println("6. Bayam");
                System.out.println("7. Kacang");
                System.out.println("8. Susu");
                System.out.println("");

                System.out.println("Dish");
                System.out.println("1. Nasi Ayam");
                System.out.println("2. Nasi Kari");
                System.out.println("3. Susu Kacang");
                System.out.println("4. Tumis Sayur");
                System.out.println("5. Bistik");
            } else if (menuInput.equals("10") || menuInput.equalsIgnoreCase("Go To Object")) {
                // TODO : Go To Object
                HashMap<Coordinate, Items> listItemInRoom = currentRoom.getObject();
                System.out.println("Berikut adalah List Object yang ada di " + currentRoom.getRoomName() + " : ");
                int i = 1;
                for(Items item : listItemInRoom.keySet())
                {
                    System.out.println(i + ". " + item.getName());
                    i++;
                }
                System.out.println("");
                String currentObject; 
                Boolean inputbenar = false;
                int itemindex;
                while(!inputbenar)
                {
                    System.out.print("Masukkan nama object yang ingin dituju : ");
                    String itemName = input.nextLine();
                    for(Items item : listItemInRoom.keySet())
                    {
                        if(itemName.equalsIgnoreCase(item.getName()))
                        {
                            inputbenar = true;
                            break;
                            
                        }
                    }
                    if(!inputbenar)
                    {
                        System.out.println("Object tidak ditemukan");
                        System.out.println("Silakan masukan object ulang");
                        System.out.println("");
                    }
                    currentObject = itemName;
                }

                
                System.out.print("Apakah Anda ingin melakukan action pada object ini? (Y/N) : ");
                String yesno = input.nextLine();
                while(!(yesno.equals("Y") || yesno.equals("N")))
                {
                    System.out.println("Input tidak dikenali");
                    System.out.println("Silakan masukan input ulang");
                    System.out.println("");
                    System.out.print("Apakah Anda ingin melakukan action pada object ini? (Y/N) : ");
                    yesno = input.nextLine();
                }
                
                switch(currentObject){
                    case "Toilet" :
                        if (currentSim.getFullness()<20){
        
                            System.out.println("Perut anda terlalu kosong untuk melakukan aktivitas buang air besar");
                            
                        }
                        else {
                            currentSim.defecate();
                            
                            
                        }
                        break;
                    case "TV" : 
                        if (currentSim.getFullness()<5 && currentSim.getHeath()<5){
        
                            System.out.println("Anda terlalu lapar atau kurang sehat untuk menonton TV");
                            
                        }
                        else{
                            boolean check = false;
                            while(!check){
                                int inputTime = input.nextInt();
                                if (inputTime%30!=0 || (inputTime/30)*5>currentSim.getFullness() || (inputTime/30)*5>currentSim.getHeath()){
                                    check = false;
                                    System.out.println("Masukkan waktu harus keliapatan 30 atau status kesejahteraan anda tidak mencukupi");
                                }
                                else{
                                    check = true;
                                    currentSim.watchingTV(inputTime);
                                }
                            }
                            
                        }
                        break;
                    case "Komputer" :
                        if (currentSim.getFullness()<10 && currentSim.getHeath()<10){
        
                            System.out.println("Anda terlalu lapar atau kurang sehat untuk bermain game");
                        
                        }
                        else{
                            boolean check = false;
                            while(!check){
                                int inputTime = input.nextInt();
                                if (inputTime%20!=0 || (inputTime/20)*10>currentSim.getFullness() || (inputTime/20)*10>currentSim.getHeath()){
                                    check = false;
                                    System.out.println("Masukkan waktu harus keliapatan 20 atau status kesejahteraan anda tidak mencukupi");
                                }
                                else{
                                    check = true;
                                    currentSim.playingGame(inputTime);
                                }
                            }
                            
                        }
                        break;
                    case "Kolam Renang" :
                        if (currentSim.getFullness()<15){
        
                            System.out.println("Anda terlalu lapar untuk beranang");
                    
                        }
                        else{
                            boolean check = false;
                            while(!check){
                                int inputTime = input.nextInt();
                                if (inputTime%30!=0 || (inputTime/30)*15>currentSim.getFullness()){
                                    check = false;
                                    System.out.println("Masukkan waktu harus keliapatan 30 atau status kesejahteraan anda tidak mencukupi");
                                }
                                else{
                                    check = true;
                                    currentSim.swiming(inputTime);
                                }
                            }
                            
                        }
                        break;
                    case "Shower" :
                        if (currentSim.getFullness()<10){
                            System.out.println("Anda terlalu lapar untuk mandi");
                    
                        }
                        else{
                            boolean check = false;
                            while(!check){
                                int inputTime = input.nextInt();
                                if (inputTime%15!=0 || (inputTime/15)*10>currentSim.getFullness()){
                                    check = false;
                                    System.out.println("Masukkan waktu harus keliapatan 15 atau status kesejahteraan anda tidak mencukupi");
                                }
                                else{
                                    check = true;
                                    currentSim.swiming(inputTime);
                                }
                            }
                            
                        }
                        break;
                    
                            
                            
                                case "Jam" :
                                    currentSim.viewClock();
                                case "Meja dan Kursi" :
                                    currentSim.getInventoryfood().printInventory();
                                    currentSim.getInventorydish().printInventory();
                                    System.out.println("Pilih makanan untuk dimakan");
                                    boolean check = true;
                                    boolean isFood = true;
                                    while (check){
                                        String inputMakanan = input.nextLine();
                                        if (currentSim.getInventoryfood().getInventory().containsKey(new Food(inputMakanan))){
                                            currentSim.eat(new Food(inputMakanan), currentSim.getInventorydish(), currentSim.getInventoryfood());
                                            check = false;
                                        }
                                        else if(currentSim.getInventorydish().getInventory().containsKey(inputMakanan)){
                                            currentSim.eat(new Dish(inputMakanan), currentSim.getInventorydish(), currentSim.getInventoryfood());
                                        }
                                        else{
                                            System.out.println("Kamu tidak memiliki makanan tersebut di inventory, mohon masukkan kembali makanan yang ingin dimakan");
                                        }
                                    }
                                    
                                case "Kompor Gas" :
                                case "Kompor Listrik" :
                                boolean check3 = true;
                                System.out.println("Pilih makanan yang ingin dimasak");
                                System.out.println("1. Nasi Ayam");
                                System.out.println("2. Nasi Kari");
                                System.out.println("3. Susu Kacang");
                                System.out.println("4. Tumis Sayur");
                                System.out.println("5. Bistik");
                                String makanan = input.nextLine();
                                Dish dish = new Dish(makanan);
                                for (String foods: dish.getIngredient()){
                                    if (!currentSim.getInventoryfood().getInventory().containsKey(foods)){
                                        check3 = false;
                                    }
                                }
                                if (check3){
                                    currentSim.cook(dish,currentSim.getInventorydish(),currentSim.getInventoryfood());
                                }
                                else {
                                    System.out.println("Bahan makanan tidak cukup untuk memasak");
                                }
                                break;
                                default : 
                                int waktuTidur = input.nextInt();
                                    try{
                                        if (waktuTidur%180!=0){
                                            throw new Exception("Input waktu adalah kelipatan 180 detik atau 3 menit");
                                        }
                        
                                        else{
                                            currentSim.sleep(waktuTidur);
        
                                        }
                                    }catch(Exception e){
                                        System.out.println(e.getMessage());
                                    }
                                
                                    
                            
                        
                }


            }
            else if(actionMenuInput.equals("11")|| actionMenuInput.equalsIgnoreCase("Action"))
            {
                // TODO: Action
            } else if (menuInput.equals("12") || menuInput.equalsIgnoreCase("Exit")) {
                // TODO: Exit
            }
            else if(actionMenuInput.equals("13")|| actionMenuInput.equalsIgnoreCase("Beli barang"))
            {
                // TODO: Beli barang
                System.out.println("Berikut adalah items yang tersedia beserta harganya:");
                System.out.println("1. Kasur Single     | 50");
                System.out.println("2. Kasur Queen Size | 100");
                System.out.println("3. Kasur King Size  | 150");
                System.out.println("4. Toilet           | 50");
                System.out.println("5. Kompor Gas       | 100");
                System.out.println("6. Kompor Listrik   | 200");
                System.out.println("7. Meja dan Kursi   | 50");
                System.out.println("8. Jam              | 10");

                System.out.print("Masukkan nomor item yang ingin dibeli: ");
                int item = input.nextInt();
                Items items;
                switch (item) {
                    case 1:
                        items = new Items("Kasur Single");
                        break;
                    case 2:
                        items = new Items("Kasur Queen Size");
                        break;
                    case 3:
                        items = new Items("Kasur King Size");
                        break;
                    case 4:
                        items = new Items("Toilet");
                        break;
                    case 5:
                        items = new Items("Kompor Gas");
                        break;
                    case 6:
                        items = new Items("Kompor Listrik");
                        break;
                    case 7:
                        items = new Items("Meja dan Kursi");
                        break;
                    case 8:
                        items = new Items("Jam");
                        break;
                    default:
                        throw new IllegalArgumentException("Item tidak tersedia");
                }

                System.out.print("Masukkan jumlah item yang ingin dibeli: ");
                int jumlah = input.nextInt();

                if ((items.getPrice() * jumlah) > currentSim.getMoney()) {
                    System.out.println("Maaf, uang anda tidak cukup untuk membeli item tersebut");
                } else {
                    System.out.println("Item berhasil dibeli");
                    currentSim.setMoney(currentSim.getMoney() - (items.getPrice() * jumlah));
                    currentSim.addInventoryitems(items);
                }

            } else if (menuInput.equals("14") || menuInput.equalsIgnoreCase("Memasang barang")) {
                // TODO: Memasang barang
                System.out.println("Sekarang Kamu berada di " + currentRoom.getRoomName());
                currentRoom.printSpace();
                System.out.println("");

                Inventory<Items> itemsInventory = currentSim.getInventoryitems();
                ArrayList<Items> listItems =  itemsInventory.getInventoryList();
                if(listItems.isEmpty())
                {
                    System.out.println("Inventory is empty. Buy some stuff ?");
                }
                else
                {
                    System.out.println("Berikut adalah List Item yang dimiliki : ");
                    for(int i = 0; i < listItems.size(); i++)
                    {
                        System.out.println((i+1) + ". " + listItems.get(i).getName());
                    }
                    System.out.println("");

                    Boolean inputbenar = false;
                    

                    Items item = null;
                    String itemName;
                    while(!inputbenar)
                    {
                        System.out.print("Masukkan nama item yang ingin dipasang : ");
                        itemName = input.nextLine();
                        for(int i = 0; i < listItems.size(); i++)
                        {
                            if(itemName.equalsIgnoreCase(listItems.get(i).getName()))
                            {
                                inputbenar = true;
                                item = listItems.get(i);
                                break;
                            }
                        }
                        if(!inputbenar)
                        {
                            System.out.println("Item tidak ditemukan");
                            System.out.println("Silakan masukan item ulang");
                            System.out.println("");
                        }
                    }

                    Boolean isPlaced = currentRoom.placeObject(item);
                    if(isPlaced)
                    {
                        itemsInventory.reduceInventory(itemName);
                    }
                }
            }
            else
            {
                // Invalid Input
                System.out.println("Aksi tidak dikenali!");
                System.out.println("");
            }
        }
    }
}