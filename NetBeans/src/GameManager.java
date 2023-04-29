import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.util.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    private static List<Sim> simList = new ArrayList<>();
    private Sim sim;
    
    public static void addSim(String nama , List<Sim> simList){
        Sim sim = new Sim(nama);
        simList.add(sim);
    }

    public static void changeSim(String nama){
        Sim sim = null;
        for(Sim s : simList){
            if(s.getName().equals(nama)){
                sim = s;
                break;
            }
        }
    }

    public static void printActionMenu()
    {
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

    public static void help()
    {
        // Isi Help Disini
        // ---------------
    }

    public static void exit()
    {
        // Isi Exit Disini
        // ---------------
    }

    public static void main(String[] args) {
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
        while(!validInput)
        {
            // Masukan Pilihan
            System.out.print("Masukkan Pilihan Anda: ");
            String pilihan = input.nextLine();

            if(pilihan.equals("1") || pilihan.equalsIgnoreCase("Start New Game"))
            {
                // Start New Game
                System.out.println("Masukkan Nama Sim: ");
                String namaSim = input.nextLine();
                world = new World();
                
                // Random Posisi Rumah Pertama
                int max = 63;
                int min = 0;
                int x = (int)(Math.random()*(max-min+1)+min); 
                int y = (int)(Math.random()*(max-min+1)+min);
                
                Point coordinate = new Point(x,y);
                House firstHouse = new House(coordinate);
                
                // membuat Sim pertama
                Sim firstSim = new Sim(namaSim , firstHouse);
                
                // Memasukan Sim kedalam SimList
                addSim(namaSim , simList);
                
                // currentSim mengacu ke firstSim
                currentSim = simList.get(0);
                
                // Memasukan House ke dalam World
                world.addHouse(currentSim.getHouse());
                currentHouse = currentSim.getHouse();
                currentRoom = currentHouse.getRoom();
                validInput = true;
            }
            else if(pilihan.equals("2") || pilihan.equalsIgnoreCase("Help"))
            {
                // Help
                help();
                validInput = true;
            }
            else if(pilihan.equals("3") || pilihan.equalsIgnoreCase("Exit"))
            {
                // Exit
                exit();
                validInput = true;
            }
            else
            {
                // Invalid Input
                System.out.println("Invalid Input");
            }
        }

        System.out.println("Selamat datang " + currentSim.getName() + "di dunia SIM!");
        System.out.println("");

        for(int i=0; i<4; i++) {
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
            }
            else if(actionMenuInput.equals("2")|| actionMenuInput.equalsIgnoreCase("View Current Location"))
            {
                // TODO: View Current Location
            }
            else if(actionMenuInput.equals("3")|| actionMenuInput.equalsIgnoreCase("View Inventory"))
            {
                // TODO: View Inventory
            }
            else if(actionMenuInput.equals("4")|| actionMenuInput.equalsIgnoreCase("Upgrade House"))
            {
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
            }
            else if(actionMenuInput.equals("6")|| actionMenuInput.equalsIgnoreCase("Edit Room"))
            {
                // TODO: Edit Room
            }
            else if(actionMenuInput.equals("7")|| actionMenuInput.equalsIgnoreCase("Add Sim"))
            {
                // TODO: Add Sim
            }
            else if(actionMenuInput.equals("8")|| actionMenuInput.equalsIgnoreCase("Change Sim"))
            {
                // TODO: Change Sim
            }
            else if(actionMenuInput.equals("9")|| actionMenuInput.equalsIgnoreCase("List Object"))
            {
                // TODO: List Object
            }
            else if(actionMenuInput.equals("10")|| actionMenuInput.equalsIgnoreCase("Go To Object"))
            {
                // TODO : Go To Object
            }
            else if(actionMenuInput.equals("11")|| actionMenuInput.equalsIgnoreCase("Action"))
            {
                // TODO: Action
            }
            else if(actionMenuInput.equals("12")|| actionMenuInput.equalsIgnoreCase("Exit"))
            {
                // TODO: Exit
            }
            else if(actionMenuInput.equals("13")|| actionMenuInput.equalsIgnoreCase("Beli barang"))
            {
                // TODO: Beli barang
            }
            else if(actionMenuInput.equals("14")|| actionMenuInput.equalsIgnoreCase("Memasang barang"))
            {
                // TODO: Memasang barang
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