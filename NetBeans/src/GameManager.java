import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.lang.Math;
import java.util.*;
import java.util.Map.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    private static List<Sim> simList = new ArrayList<>();
    private static Sim currentSim = null;
    private static World world = null;
    // House currentHouse = null;
    private static Room currentRoom = null;

    public static void addSim(String nama, World world, House house) {
        Sim sim = new Sim(nama, house, world);
        simList.add(sim);
    }

    public static List<Sim> getSimList() {
        return simList;
    }

    public static void changeSim(String nama) {
        for (Sim s : simList) {
            if (s.getName().equals(nama)) {
                currentSim = s;
                break;
            }
        }
    }

    public static void printActionMenu() {
        System.out.println(" ");
        System.out.println("Menu: ");
        System.out.println("0.  View Menu");
        System.out.println("1.  View Sim Info");
        System.out.println("2.  View Current Location");
        System.out.println("3.  View Inventory");
        System.out.println("4.  Upgrade House");
        System.out.println("5.  Move Room");
        System.out.println("6.  Edit Room");
        System.out.println("7.  Add Sim");
        System.out.println("8.  Change Sim");
        System.out.println("9.  List Object");
        System.out.println("10. Go To Object");
        System.out.println("11. Action");
        System.out.println("12. Exit");
        System.out.println("99. Help");
        System.out.println("");
        System.out.println("Action: ");
        System.out.println("13. Beli barang");
        System.out.println("14. Memasang barang");
        System.out.println("");
    }

    public static void Welcome() {
        String welcome2 = "        ██╗    ███████████╗     ██████╗██████╗███╗   ██████████╗    ████████╗██████╗     ████████████╗   ██████████╗\n"
                +
                "        ██║    ████╔════██║    ██╔════██╔═══██████╗ ██████╔════╝    ╚══██╔══██╔═══██╗    ██╔════██████╗ ██████╔════╝\n"
                +
                "        ██║ █╗ ███████╗ ██║    ██║    ██║   ████╔████╔███████╗         ██║  ██║   ██║    ███████████╔████╔█████████╗\n"
                +
                "        ██║███╗████╔══╝ ██║    ██║    ██║   ████║╚██╔╝████╔══╝         ██║  ██║   ██║    ╚════██████║╚██╔╝██╚════██║\n"
                +
                "        ╚███╔███╔██████████████╚██████╚██████╔██║ ╚═╝ █████████╗       ██║  ╚██████╔╝    ███████████║ ╚═╝ █████████║\n"
                +
                "         ╚══╝╚══╝╚══════╚══════╝╚═════╝╚═════╝╚═╝     ╚═╚══════╝       ╚═╝   ╚═════╝     ╚══════╚═╚═╝     ╚═╚══════╝\n";

        System.out.println("");
        System.out.println(welcome2);

    }

    public static void help() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih Deskripsi Game yang ingin dipilih: ");
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
        System.out.println("99.Help");
        System.out.println("");
        System.out.println("action: ");
        System.out.println("13.Beli barang");
        System.out.println("14.Memasang barang");
        System.out.println("");
        System.out.print("Masukkan Pilihan :");
        String inputhelp = input.nextLine();
        boolean valid = false;

        while (!valid) {
            if (inputhelp.equals("1")) {
                System.out.println(
                        "Menampilkan informasi Sim tentang nama, Pekerjaan, Kesehatan, Kekenyangan, Mood, Uang ");
                valid = true;
            } else if (inputhelp.equals("2")) {
                System.out.println("Menampilkan lokasi dari Sim berupa Rumah dan Ruangan");
                valid = true;
            } else if (inputhelp.equals("3")) {
                System.out.println("Menampilkan isi inventory milik sebuah Sim");
                valid = true;
            } else if (inputhelp.equals("4")) {
                System.out.println("Melakukan upgrade rumah pada currentSim");
                valid = true;
            } else if (inputhelp.equals("5")) {
                System.out.println("Mengganti ruangan yang ada pada rumah yang sedang ditempati Sim");
                valid = true;
            } else if (inputhelp.equals("6")) {
                System.out.println("Pembelian barang baru atau pemindahan barang");
                valid = true;
            } else if (inputhelp.equals("7")) {
                System.out.println("Menambahkan Sim baru");
                valid = true;
            } else if (inputhelp.equals("8")) {
                System.out.println("Mengganti current Sim");
                valid = true;
            } else if (inputhelp.equals("9")) {
                System.out.println("Menampilkan List Objek");
                valid = true;
            } else if (inputhelp.equals("10")) {
                System.out.println("Sim berjalan menuju ke suatu objek");
                valid = true;
            } else if (inputhelp.equals("11")) {
                System.out.println("Melakukan sebuah aksi");
                valid = true;
            } else if (inputhelp.equals("12")) {
                System.out.println("Keluar dari game");
                valid = true;
            } else if (inputhelp.equals("13")) {
                System.out.println("Membeli suatu barang");
                valid = true;
            } else if (inputhelp.equals("14")) {
                System.out.println("Memasang barang di suatu ruangan");
                valid = true;
            } else {
                System.out.print("Input anda salah silahkan masukkan ulang!! :");
                inputhelp = input.nextLine();
            }
        }

    }

    public static void exit() {
        // Isi Exit Disini
        // ---------------
        String exit = "        ██████╗██╗   █████████╗    ██████╗██╗   █████████╗    ██╗\n" +
                "        ██╔══██╚██╗ ██╔██╔════╝    ██╔══██╚██╗ ██╔██╔════╝    ██║\n" +
                "        ██████╔╝╚████╔╝█████╗      ██████╔╝╚████╔╝█████╗      ██║\n" +
                "        ██╔══██╗ ╚██╔╝ ██╔══╝      ██╔══██╗ ╚██╔╝ ██╔══╝      ╚═╝\n" +
                "        ██████╔╝  ██║  ███████╗    ██████╔╝  ██║  ███████╗    ██╗\n" +
                "        ╚═════╝   ╚═╝  ╚══════╝    ╚═════╝   ╚═╝  ╚══════╝    ╚═╝\n";

    }

    public static void main(String[] args) throws Exception {
        Welcome();

        Scanner input = new Scanner(System.in);

        // Welcome Page is Here
        // --------------------

        // Menu Option pertama
        System.out.println("");
        System.out.println("Pilihlah salah satu menu di bawah ini: ");
        System.out.println("1. Start New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Help");
        System.out.println("4. Exit");

        Boolean validInput = false;
        Boolean exit = false;
        while (!validInput) {
            // Masukkan Pilihan
            System.out.println("");
            System.out.print("Masukkan pilihan Anda: ");
            String pilihan = input.nextLine();

            if (pilihan.equals("1") || pilihan.equalsIgnoreCase("Start New Game")) {

                System.out.print("Masukkan Nama Sim: ");
                String namaSim = input.nextLine();
                world = new World();

                // Random Posisi Rumah Pertama
                int max = 63;
                int min = 0;
                int x = (int) (Math.random() * (max - min + 1) + min);
                int y = (int) (Math.random() * (max - min + 1) + min);
                while (world.isHouseExist(x, y)) {
                    x = (int) (Math.random() * (max - min + 1) + min);
                    y = (int) (Math.random() * (max - min + 1) + min);
                }

                Point coordinate = new Point(x, y);
                House firstHouse = new House(coordinate, namaSim);

                // membuat Sim pertama
                Sim firstSim = new Sim(namaSim, firstHouse, world);

                // menset upgradeHouseTime baru untuk sim pertama

                // Memasukan Sim kedalam SimList
                addSim(namaSim, world, firstHouse);

                // currentSim mengacu ke firstSim
                currentSim = simList.get(0);

                // Memasukan House ke dalam World
                world.addHouse(currentSim.getHouse());

                // Menambahkan Item Default kedalam first-room
                Items item1 = new Items("Kasur Single");
                Items item2 = new Items("Toilet");
                Items item3 = new Items("Kompor Gas");
                Items item4 = new Items("Jam");
                Items item5 = new Items("Meja dan Kursi");
                currentSim.addInventoryitems(item1);
                currentSim.addInventoryitems(item2);
                currentSim.addInventoryitems(item3);
                currentSim.addInventoryitems(item4);
                currentSim.addInventoryitems(item5);

                // currentSim.getCurrentRoom().setSpaceImmediate(0,2,item1,"KS" ,"Down");
                // currentSim.getCurrentRoom().setSpaceImmediate(5,5,item2,"T" , "Right");
                // currentSim.getCurrentRoom().setSpaceImmediate(2,5,item3,"KG","Right");
                // currentSim.getCurrentRoom().setSpaceImmediate(5,0,item4,"J","Right");
                // currentSim.getCurrentRoom().setSpaceImmediate(2,1,item5,"MDK","Right");

                validInput = true;
            } else if (pilihan.equals("2") || pilihan.equalsIgnoreCase("Load Game")) {
                boolean valid = false;
                System.out.print("Masukkan username: ");
                String username = input.nextLine();
                while (!valid) {
                    File file = new File(username + ".json");
                    if (file.exists()) {
                        valid = true;
                    } else {
                        System.out.println("Username not found!! Please enter a valid username!");
                        System.out.print("Masukkan username: ");
                        username = input.nextLine();
                    }
                }
                currentSim = Load.load(username);
                validInput = true;

            } else if (pilihan.equals("3") || pilihan.equalsIgnoreCase("Help")) {
                // Help
                help();
                validInput = true;
            } else if (pilihan.equals("4") || pilihan.equalsIgnoreCase("Exit")) {
                // Exit
                validInput = true;
                exit = true;
                exit();
            } else {
                // Invalid Input
                System.out.println("Invalid Input. Please try again!");
            }
        }

        if (!exit) {
            System.out.println("Selamat datang " + currentSim.getName() + " di dunia Sim-Plicity!");
            System.out.println("");

            // for (int i = 0; i < 4; i++) {
            // System.out.print("\rHold on , we are Generating Sims Map . . . . . ");
            // Thread.sleep(1000);
            // System.out.print("\r ");
            // Thread.sleep(1000);
            // }

            System.out.println("Map Generated!");
            System.out.println("Kamu sekarang berada di " + currentSim.getCurrentRoom().getRoomName());
            currentSim.getCurrentRoom().printSpace();
            System.out.println("");

            Boolean simInHouse = true;
            printActionMenu();
            while (!exit) {
                System.out.print("Masukkan pilihan Anda (Angka/Aksi): ");
                String actionMenuInput = input.nextLine();
                if (actionMenuInput.equals("0") || actionMenuInput.equalsIgnoreCase("View Menu")) {
                    printActionMenu();
                } else if (actionMenuInput.equals("1") || actionMenuInput.equalsIgnoreCase("View Sim Info")) {
                    currentSim.viewSimInfo();
                } else if (actionMenuInput.equals("2") || actionMenuInput.equalsIgnoreCase("View Current Location")) {
                    currentSim.viewCurrentLocation();
                } else if (actionMenuInput.equals("3") || actionMenuInput.equalsIgnoreCase("View Inventory")) {
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
                    System.out.println(" ");

                } else if (actionMenuInput.equals("4") || actionMenuInput.equalsIgnoreCase("Upgrade House")) {
                    // TODO: Upgrade House

                    // Validasi apakah Sims berada didalam Rumah
                    if (currentSim.getisBerkunjung()) {
                        System.out.println("Sim tidak berada di dalam Rumah");
                    }

                    // Validasi Uang Sim
                    else if (currentSim.getMoney() < 1500) {
                        System.out.println("Uang tidak cukup");
                    }

                    // Validasi apakah sedang Upgrade
                    else if (currentSim.getCurrHouse().getUpgradeHouseTime() > 0) {
                        System.out.println("Anda sedang mengupgrade Rumah");
                    }

                    else {
                        // Memasukan Nama Ruangan Baru
                        System.out.print("Masukkan nama Ruangan baru: ");
                        String namaRumah = input.nextLine();

                        // Cek Apakah Nama Ruangan sudah ada
                        Boolean namaRumahValid = false;
                        while (!namaRumahValid) {
                            if (currentSim.getCurrHouse().isRoomExist(namaRumah)) {
                                // System.out.println("Nama Ruangan sudah ada");
                                System.out.print("Masukkan nama Ruangan baru: ");
                                namaRumah = input.nextLine();
                            } else {
                                namaRumahValid = true;
                            }
                        }

                        Room room = new Room(namaRumah);

                        Room[] rooms = currentSim.getCurrHouse().getRooms();
                        for (int i = 0; i < currentSim.getCurrHouse().getRoomsTotal(); i++) {
                            System.out.printf("%d. %s", i + 1, rooms[i].getRoomName());
                            System.out.println("");
                        }

                        Boolean roomRootSet = false;
                        Room roomRoot = null;

                        while (!roomRootSet) {
                            System.out.print("Masukkan nama Ruangan yang akan dihubungkan: ");
                            String roomRootName = input.nextLine();

                            for (int i = 0; i < currentSim.getCurrHouse().getRoomsTotal(); i++) {
                                if (rooms[i].getRoomName().equalsIgnoreCase(roomRootName)) {
                                    roomRoot = rooms[i];
                                }
                            }

                            if (roomRoot == null) {
                                System.out.println("Ruangan tidak ditemukan");
                            }

                            else {
                                roomRootSet = true;
                            }
                        }

                        System.out.println(
                                "Berikut adalah Ruangan yang terkoneksi dengan Ruangan " + roomRoot.getRoomName());
                        currentSim.getCurrHouse().printAroundRoom(roomRoot);
                        // roomRoot.printAroundRoom();
                        System.out.println("");

                        // Check Apakah masih ada ruang yang bisa ditambahkan disekitar RoomRoot
                        if (currentSim.getCurrHouse().isAvailableAroundRoom(roomRoot)) {
                            Boolean isRoomSet = false;

                            while (!isRoomSet) {
                                System.out.print("Masukkan Posisi Ruangan Baru (Up, Down, Right, Left): ");
                                String direction = input.nextLine();

                                // Check inputnya Up Down Right Left
                                while (!(direction.equalsIgnoreCase("Up") || direction.equalsIgnoreCase("Down")
                                        || direction.equalsIgnoreCase("Right") || direction.equalsIgnoreCase("Left"))) {
                                    System.out.println("Posisi Ruangan tidak valid");
                                    System.out.print("Masukkan Posisi Ruangan Baru (Up, Down, Right, Left): ");
                                    direction = input.nextLine();
                                }

                                // Check Apakah Ruangan yang dimasukan sudah ditempatkan atau belom
                                if (direction.equalsIgnoreCase("Up")
                                        && currentSim.getCurrHouse().upperRoomExist(roomRoot)) {
                                    System.out.println("Room is Exist");
                                    System.out.println("The Room is : "
                                            + currentSim.getCurrHouse().getUpperRoom(roomRoot).getRoomName());
                                }

                                else if (direction.equalsIgnoreCase("Down")
                                        && currentSim.getCurrHouse().lowerRoomExist(roomRoot)) {
                                    System.out.println("Room is Exist");
                                    System.out.println("The Room is : "
                                            + currentSim.getCurrHouse().getLowerRoom(roomRoot).getRoomName());
                                }

                                else if (direction.equalsIgnoreCase("Right")
                                        && currentSim.getCurrHouse().rightRoomExist(roomRoot)) {
                                    System.out.println("Room is Exist");
                                    System.out.println("The Room is : "
                                            + currentSim.getCurrHouse().getRightRoom(roomRoot).getRoomName());
                                }

                                else if (direction.equalsIgnoreCase("Left")) {
                                    System.out.println("Room is Exist");
                                    System.out.println("The Room is : "
                                            + currentSim.getCurrHouse().getLeftRoom(roomRoot).getRoomName());
                                } else {
                                    currentSim.getCurrHouse().setRoomRoot(roomRoot);
                                    currentSim.getCurrHouse().setNewRoom(room);
                                    currentSim.getCurrHouse().setDirectionNewRoom(direction);
                                    currentSim.getCurrHouse().setUpgradeHouseTime(1080);
                                    System.out.println(
                                            "Upgrade Time = " + currentSim.getCurrHouse().getUpgradeHouseTime());
                                    isRoomSet = true;
                                }
                            }
                        }

                        else {
                            System.out.println(
                                    "Ruangan tidak bisa diupgrade karena kiri - kanan - atas - bawah sudah ada ruangan");
                        }
                    }
                } else if (actionMenuInput.equals("5") || actionMenuInput.equalsIgnoreCase("Move Room")) {
                    // TODO: Move Room

                    // Validasi apakah Sims berada didalam Rumah
                    if (currentSim.getisBerkunjung()) {
                        System.out.println("Sim tidak berada di dalam rumah");
                    }

                    Room[] listRooms = currentSim.getCurrHouse().getRooms();
                    System.out.println("Berikut adalah list Ruangan yang tersedia : ");
                    for (int i = 0; i < currentSim.getCurrHouse().getRoomsTotal(); i++) {
                        System.out.println((i + 1) + ". " + listRooms[i].getRoomName());
                    }
                    System.out.println("");

                    Boolean inputbenar = false;
                    int roomindex = (-1);
                    while (!inputbenar) {
                        System.out.print("Masukkan nama Ruangan yang ingin dipindahkan : ");
                        String roomName = input.nextLine();
                        for (int i = 0; i < currentSim.getCurrHouse().getRoomsTotal(); i++) {
                            if (roomName.equalsIgnoreCase(listRooms[i].getRoomName())) {
                                inputbenar = true;
                                roomindex = i;
                                break;
                            }
                        }
                        if (!inputbenar) {
                            System.out.println("Ruangan tidak ditemukan");
                            System.out.println("Silakan masukkan nama Ruangan ulang");
                            System.out.println("");
                        }
                    }

                    Room newcurrentRoom = currentSim.getCurrHouse().getRoom(roomindex);
                    System.out.println("Sim berhasil berpindah ke Ruangan " + newcurrentRoom.getRoomName());
                    System.out.println("");

                    System.out.println(newcurrentRoom.getRoomName());
                    newcurrentRoom.printSpace();
                    System.out.println("");

                    currentSim.setCurrentRoom(newcurrentRoom);
                }

                else if (actionMenuInput.equals("6") || actionMenuInput.equalsIgnoreCase("Edit Room")) {
                    // TODO: Edit Room

                    // Validasi Apakah Sim berada didalam Rumah
                    if (currentSim.getisBerkunjung()) {
                        System.out.println("Sim tidak berada di dalam rumah");
                    }

                    else {
                        currentSim.getCurrentRoom().printSpace();
                        System.out.println("");

                        // Menampilkan Object apa saja yang dipunyai
                        System.out.println("Berikut adalah List Object yang ada di "
                                + currentSim.getCurrentRoom().getRoomName() + " : ");
                        HashMap<Coordinate, Items> listItemInRoom = currentSim.getCurrentRoom().getObject();
                        int i = 1;
                        for (Coordinate coordinate : listItemInRoom.keySet()) {
                            System.out.println(
                                    i + ". " + listItemInRoom.get(coordinate).getName() + " | Coordinate = " + " ("
                                            + coordinate.getX1() + "," + coordinate.getY1() + ")" + " - ("
                                            + coordinate.getX2() + ","
                                            + coordinate.getY2() + ")");
                            i++;
                        }
                        System.out.println("");

                        Boolean inputbenar = false;

                        Coordinate initialCoordinate = null;
                        Items theItems = null;

                        // Memasukan Nama Object yang ingin dipindahkan
                        while (!inputbenar) {
                            System.out.print("Masukkan nama object yang ingin diubah : ");
                            String objectName = input.nextLine();
                            int x1;
                            int y1;
                            try {
                                System.out.print("Masukkan koordinat x1 : ");
                                x1 = input.nextInt();
                                System.out.print("Masukkan koordinat y1 : ");
                                y1 = input.nextInt();
                            } catch (Exception e) {
                                System.out.println("Koordinat harus berupa angka");
                                System.out.println("Silakan masukkan nama object dan koordinat ulang");
                                System.out.println("");
                                continue;
                            }

                            for (Coordinate coordinate : listItemInRoom.keySet()) {
                                if ((objectName.equalsIgnoreCase(listItemInRoom.get(coordinate).getName()))
                                        && (x1 == coordinate.getX1()) && (y1 == coordinate.getY1())) {
                                    inputbenar = true;
                                    initialCoordinate = coordinate;
                                    theItems = listItemInRoom.get(coordinate);
                                    break;
                                }
                            }

                            if (!inputbenar) {
                                System.out.println("Object tidak ditemukan");
                                System.out.println("Silakan masukan object dan coordinate ulang");
                                System.out.println("");
                            }
                        }

                        currentSim.getCurrentRoom().moveObject(theItems, initialCoordinate);
                    }
                } else if (actionMenuInput.equals("7") || actionMenuInput.equalsIgnoreCase("Add Sim")) {
                    // TODO: Add Sim
                    System.out.print("Masukkan nama : ");

                    boolean check = false;
                    while (!check) {
                        String inputNama = input.nextLine();
                        boolean checkNama = false;
                        for (Sim sim : GameManager.getSimList()) {
                            if (sim.getName().equals(inputNama)) {
                                checkNama = true;
                            }
                        }
                        if (!checkNama) {
                            int max = 63;
                            int min = 0;
                            int x = (int) (Math.random() * (max - min + 1) + min);
                            int y = (int) (Math.random() * (max - min + 1) + min);

                            Point coordinate = new Point(x, y);
                            House rumah = new House(coordinate, inputNama);

                            Sim s = new Sim(inputNama, rumah, world);
                            addSim(inputNama, world, rumah);
                            System.out.println("Sim dengan nama " + inputNama + " telah ditambahkan. ");
                            check = true;
                        } else {
                            System.out.print("Nama yang dimasukkan sudah terpakai, silahkan memilih nama kembali : ");
                        }
                    }
                } else if (actionMenuInput.equals("8") || actionMenuInput.equalsIgnoreCase("Change Sim")) {
                    // TODO: Change Sim
                    System.out.println("Pilih Sim yang ingin dimainkan: ");
                    for (Sim sim : GameManager.getSimList()) {
                        if (!currentSim.getName().equals(sim.getName())) {
                            System.out.println(sim.getName());
                        }

                    }
                    System.out.print("Masukkan nama Sim yang ingin dimainkan: ");
                    boolean check = false;
                    while (!check) {
                        String inputNama = input.nextLine();
                        boolean checkNama = false;
                        for (Sim sim : GameManager.getSimList()) {
                            if (sim.getName().equals(inputNama)) {
                                checkNama = true;
                            }
                        }
                        if (inputNama.equals(currentSim.getName())) {
                            System.out.print("Anda sedang memainkan Sim tersebut, silakan masukkan nama kembali :");
                        } else if (checkNama) {
                            changeSim(inputNama);
                            System.out.println("Sekarang anda sedang memainkan " + inputNama);
                            check = true;
                        } else {
                            System.out.print("Input nama yang dimaksukan tidak ada dalam daftar sim : ");
                        }
                    }

                } else if (actionMenuInput.equals("9") || actionMenuInput.equalsIgnoreCase("List Object")) {
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
                } else if (actionMenuInput.equals("10") || actionMenuInput.equalsIgnoreCase("Go To Object")) {
                    // TODO : Go To Object
                    HashMap<Coordinate, Items> listItemInRoom = currentSim.getCurrentRoom().getObject();
                    if (listItemInRoom.isEmpty()) {
                        System.out.println(
                                "Tidak ada object di ruangan ini , Silahkan Menempatkan Object terlebih dahulu");
                        System.out.println("");
                    } else {
                        ArrayList<Coordinate> tempListCoordinate = new ArrayList<Coordinate>();
                        System.out.println("Berikut adalah List Object yang ada di "
                                + currentSim.getCurrentRoom().getRoomName() + " : ");
                        int i = 1;
                        for (Coordinate coordinate : listItemInRoom.keySet()) {
                            System.out.println(i + ". " + listItemInRoom.get(coordinate).getName());
                            tempListCoordinate.add(coordinate);
                            i++;
                        }
                        System.out.println("");
                        Items targetObject = null;
                        Coordinate targetCoordinate = null;
                        Boolean inputbenar = false;
                        while (!inputbenar) {
                            System.out.print("Masukkan nama object yang ingin dituju (Angka): ");
                            int inputAngka;
                            try {
                                inputAngka = input.nextInt();
                                if (inputAngka > listItemInRoom.size() || inputAngka < 1) {
                                    System.out.println("Input out of index");
                                    System.out.println("Silakan masukan input ulang");
                                    System.out.println("");
                                } else {
                                    inputbenar = true;
                                    targetObject = listItemInRoom.get(tempListCoordinate.get(inputAngka - 1));
                                    targetCoordinate = tempListCoordinate.get(inputAngka - 1);
                                    input.nextLine();
                                }
                            } catch (Exception e) {
                                System.out.println("Input harus berupa angka");
                                System.out.println("Silakan masukan input ulang");
                                System.out.println("");

                            }
                        }

                        // Masukan inisial akhir objek ke simPoint
                        // if ((currentSim.getCurrentRoom().getLastItem() != "") &&
                        // (currentSim.getCurrentItems() != null) ) {
                        // currentSim.getCurrentRoom().setLastItem(currentSim.getCurrentItems().getName());
                        // }

                        // Pidahkan simPoint ke Object
                        currentSim.getCurrentRoom().setSimPoint(targetCoordinate.getX1(), targetCoordinate.getY1());

                        // Simpan inisial Objek yang ingin dituju ke variabel inisial
                        currentSim.setCurrentItems(targetObject);

                        currentSim.getCurrentRoom().setLastItem(targetObject.getName());

                        // Print Map

                        System.out.print("Apakah Anda ingin melakukan action pada object ini? (Y/N) : ");
                        String yesno = input.nextLine();
                        while (!(yesno.equals("Y") || yesno.equals("N"))) {
                            System.out.println("Input tidak dikenali");
                            System.out.println("Silakan masukan input ulang");
                            System.out.println("");
                            System.out.print("Apakah Anda ingin melakukan action pada object ini? (Y/N) : ");
                            yesno = input.nextLine();
                        }
                        if (yesno.equals("Y")) {
                            System.out.println(currentSim.getCurrentItems().getName());
                            currentSim.chooseAction(currentSim.getCurrentItems().getName());

                        }
                    }

                } else if (actionMenuInput.equals("11") || actionMenuInput.equalsIgnoreCase("Action")) {
                    // TODO: Action
                    System.out.println("Pilih action untuk dilakukan");
                    System.out.println("1. Kerja");
                    System.out.println("2. Olahraga");
                    System.out.println("3. Berkunjung");
                    System.out.println("4. Pulang");
                    if (currentSim.getCurrentItems() != null) {
                        System.out.println("5. " + currentSim.getCurrentItems().getAction());
                    }
                    boolean check = false;
                    while (!check) {
                        System.out.print("Silahkan pilih action yang ingin dilakukan : ");
                        String ActionInput = input.nextLine();
                        if (ActionInput.equals("1") || ActionInput.equals("Kerja")) {
                            boolean check1 = false;
                            while (!check1) {
                                try {
                                    System.out.print("Masukkan waktu input : ");
                                    int TimeInput = input.nextInt();
                                    input.nextLine();
                                    if (TimeInput % 120 == 0) {
                                        currentSim.work(TimeInput);
                                        check = true;
                                        check1 = true;
                                    } else {
                                        System.out.println("Input yang dimasukkan harus berkelipatan 120 detik");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Input harus berupa angka");
                                    System.out.println("Silakan masukan input ulang");
                                    System.out.println("");
                                    input.nextLine();
                                }
                            }
                        } else if (ActionInput.equals("2") || ActionInput.equals("Olahraga")) {
                            boolean check1 = false;
                            while (!check1) {
                                try {
                                    System.out.print("Masukkan waktu input : ");
                                    int TimeInput = input.nextInt();
                                    input.nextLine();
                                    if (TimeInput % 20 == 0) {
                                        currentSim.workout(TimeInput);
                                        check = true;
                                        check1 = true;
                                    } else {
                                        System.out.println("Input yang dimasukkan harus berkelipatan 20 detik");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Input harus berupa angka");
                                    System.out.println("Silakan masukan input ulang");
                                    System.out.println("");
                                    input.nextLine();

                                }
                            }
                        } else if (ActionInput.equals("3") || ActionInput.equals("Berkunjung")) {
                            if (currentSim.getHouse() == currentSim.getCurrHouse()) {

                                int i = 0;
                                for (Sim sim : GameManager.getSimList()) {
                                    if (!currentSim.getName().equals(sim.getName())) {
                                        System.out.println(sim.getName());
                                        i++;
                                    }

                                }
                                if (i == 0) {
                                    System.out.println("Tidak ada rumah lain untuk di kunjungi");
                                } else {
                                    System.out.println(" ");
                                    System.out.print("Masukkan nama sim yang ingin dikunjungi : ");
                                    boolean check1 = false;
                                    while (!check1) {
                                        String inputNama = input.nextLine();
                                        boolean checkNama = false;
                                        for (Sim sim : GameManager.getSimList()) {
                                            if (sim.getName().equals(inputNama)) {
                                                checkNama = true;
                                            }
                                        }
                                        if (inputNama.equals(currentSim.getName())) {
                                            System.out.print(
                                                    "Tidak bisa mengunjungi rumah sendiri, silakan masukkan nama kembali :");
                                        } else if (checkNama) {
                                            for (Sim sim : GameManager.getSimList()) {
                                                if (inputNama.equals(sim.getName())) {
                                                    currentSim.visit(sim.getHouse());
                                                    check = true;
                                                }

                                            }
                                        } else {
                                            System.out
                                                    .print("Input nama yang dimaksukan tidak ada dalam daftar sim : ");
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Sim sedang berkunjung");
                            }

                        } else if (ActionInput.equals("4") || ActionInput.equals("Pulang")) {
                            if (currentSim.getBerkunjung() != 0) {
                                currentSim.goHome();
                                check = true;
                            } else {
                                System.out.println("Sim sedang berada di rumah sendiri");
                                check = true;
                            }

                        } else if (currentSim.getCurrentItems() != null) {
                            if (ActionInput.equals("5")
                                    || ActionInput.equals(currentSim.getCurrentItems().getAction())) {
                                if (currentSim.getCurrentItems() != null) {
                                    currentSim.chooseAction(currentSim.getCurrentItems().getName());
                                    check = true;
                                }
                            }
                        } else {
                            System.out.println("Tidak ada action yang dimaksud silahkan masukkan input kembali");
                        }

                    }
                } else if (actionMenuInput.equals("12") || actionMenuInput.equalsIgnoreCase("Exit")) {
                    // TODO: Exit
                    System.out.println("Ingin disave? (yes/no)");
                    String yesno = input.nextLine();
                    System.out.println("Masukkan username: ");
                    String username = input.nextLine();
                    if (yesno.equals("yes")) {
                        Save.save(username, currentSim);
                    } else {
                        System.out.println("Have a nice day!");
                    }

                    System.exit(0);
                    exit();
                } else if (actionMenuInput.equals("13") || actionMenuInput.equalsIgnoreCase("Beli barang")) {
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
                    System.out.println("9. HP               | 100");
                    System.out.println("10. Sajadah         | 10");
                    System.out.println("11. Sapu            | 10");
                    System.out.println("12. TV              | 50");
                    System.out.println("13. Laptop          | 200");
                    System.out.println("14. Shower          | 50");
                    System.out.println("15. Nasi            | 5");
                    System.out.println("16. Kentang         | 3");
                    System.out.println("17. Ayam            | 10");
                    System.out.println("18. Sapi            | 12");
                    System.out.println("19. Wortel          | 3");
                    System.out.println("20. Bayam           | 3");
                    System.out.println("21. Kacang          | 2");
                    System.out.println("22. Susu            | 2");
                    boolean check = false;
                    Food foods = null;
                    Items items = null;

                    if (currentSim.getMoney() < 10) {
                        System.out.println("Uang tidak cukup untuk membeli item");
                    } else {
                        while (!check) {
                            System.out.print("Masukkan nomor item yang ingin dibeli: ");
                            int item = input.nextInt();
                            try {
                                if (item < 1 || item > 22) {
                                    throw new Exception("Input harus berupa angka antara 1-22");
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                continue;
                            }
                            switch (item) {
                                case 1:
                                    items = new Items("Kasur Single");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 2:
                                    items = new Items("Kasur Queen Size");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 3:
                                    items = new Items("Kasur King Size");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 4:
                                    items = new Items("Toilet");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 5:
                                    items = new Items("Kompor Gas");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 6:
                                    items = new Items("Kompor Listrik");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 7:
                                    items = new Items("Meja dan Kursi");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 8:
                                    items = new Items("Jam");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 9:
                                    items = new Items("HP");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 10:
                                    items = new Items("Sajadah");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 11:
                                    items = new Items("Sapu");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 12:
                                    items = new Items("TV");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 13:
                                    items = new Items("Laptop");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 14:
                                    items = new Items("Shower");
                                    if (items.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 15:
                                    foods = new Food("Nasi");
                                    if (foods.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 16:
                                    foods = new Food("Kentang");
                                    if (foods.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 17:
                                    foods = new Food("Ayam");
                                    if (foods.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 18:
                                    foods = new Food("Sapi");
                                    if (foods.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 19:
                                    foods = new Food("Wortel");
                                    if (foods.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 20:
                                    foods = new Food("Bayam");
                                    if (foods.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 21:
                                    foods = new Food("Kacang");
                                    if (foods.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;
                                case 22:
                                    foods = new Food("Susu");
                                    if (foods.getPrice() > currentSim.getMoney()) {
                                        System.out.println("Uang tidak cukup untuk membeli item ini");
                                    } else {
                                        check = true;
                                    }
                                    break;

                                default:
                                    System.out.println("Invalid Input, Masukkan input yang benar!");
                            }
                        }

                        boolean checkInt = false;
                        int jumlah = 0;
                        while (!checkInt) {
                            System.out.print("Masukkan jumlah item yang ingin dibeli: ");
                            try {
                                jumlah = input.nextInt();
                            } catch (Exception e) {
                                System.out.println("Input harus berupa angka");
                                currentSim.getInventoryitems().addInventoryList(items);
                                input.nextLine();
                            }
                            if (jumlah != 0) {
                                checkInt = true;
                            }
                        }

                        check = false;
                        while (!check) {
                            input.nextLine();
                            if (items != null) {
                                if ((items.getPrice() * jumlah) > currentSim.getMoney()) {
                                    System.out.println("Uang anda tidak cukup untuk membeli item sebanyak itu");
                                } else {
                                    System.out.println("Item berhasil dibeli");
                                    System.out.println("");
                                    System.out.println("Tunggu ya, Item sedang diantar...");
                                    currentSim.setMoney(currentSim.getMoney() - (items.getPrice() * jumlah));
                                    currentSim.addItemOrder(items.getName(), jumlah, items.getPrice());
                                    check = true;
                                }
                            } else {
                                if ((foods.getPrice() * jumlah) > currentSim.getMoney()) {
                                    System.out.println("Uang anda tidak cukup untuk membeli item sebanyak itu");
                                } else {
                                    System.out.println("Makanan berhasil dibeli");
                                    System.out.println("");
                                    System.out.println("Tunggu ya, Makanan sedang diantar...");
                                    currentSim.setMoney(currentSim.getMoney() - (foods.getPrice() * jumlah));
                                    currentSim.addFoodOrder(foods.getName(), jumlah, foods.getPrice());
                                    check = true;
                                }
                            }
                        }
                    }

                } else if (actionMenuInput.equals("14") || actionMenuInput.equalsIgnoreCase("Memasang barang")) {
                    // TODO: Memasang barang
                    System.out.println("Sekarang Kamu berada di " + currentSim.getCurrentRoom().getRoomName());
                    currentSim.getCurrentRoom().printSpace();
                    System.out.println("");

                    Inventory<Items> itemsInventory = currentSim.getInventoryitems();
                    ArrayList<Items> listItems = itemsInventory.getInventoryList();
                    if (listItems.isEmpty()) {
                        System.out.println("Inventory is empty. Buy some stuff?");
                    } else {
                        System.out.println("Berikut adalah List Item yang dimiliki: ");
                        for (int i = 0; i < listItems.size(); i++) {
                            if (listItems.get(i) != null) {
                                System.out.println((i + 1) + ". " + listItems.get(i).getName());
                            }
                        }
                        System.out.println("");

                        Boolean inputbenar = false;

                        Items item = null;
                        String itemName = "";
                        while (!inputbenar) {
                            System.out.print("Masukkan nama item yang ingin dipasang : ");
                            itemName = input.nextLine();
                            for (int i = 0; i < listItems.size(); i++) {
                                if (listItems.get(i) != null) {
                                    if (itemName.equals(listItems.get(i).getName())) {
                                        inputbenar = true;
                                        item = listItems.get(i);
                                        break;
                                    }
                                }
                            }
                            if (!inputbenar) {
                                System.out.println("Item tidak ditemukan");
                                System.out.println("Silakan masukan item ulang");
                                System.out.println("");
                            }
                        }

                        Boolean isPlaced = currentSim.getCurrentRoom().placeObject(item);
                        if (isPlaced) {
                            itemsInventory.reduceInventory(itemName);
                        }
                    }
                } else if (actionMenuInput.equals("99") || actionMenuInput.equalsIgnoreCase("Help")) {
                    help();
                } else {
                    // Invalid Input
                    System.out.println("Aksi tidak dikenali!");
                    System.out.println("");
                }
            }
        }
    }
}