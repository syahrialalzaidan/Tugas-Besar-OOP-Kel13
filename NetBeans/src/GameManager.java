import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.util.*;

public class GameManager {
    private static List<Sim> simList = new ArrayList<>();
    private Sim sim;

    public static void addSim(String nama, List<Sim> simList) {
        Sim sim = new Sim(nama);
        simList.add(sim);
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
                Sim firstSim = new Sim(namaSim, firstHouse);

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

        while (!exit) {
            System.out.print("Masukan Pilihan Anda (Angka / Aksi): ");
            if (menuInput.equals("1") || menuInput.equalsIgnoreCase("View Sim Info")) {
                // TODO: View Sim Info
            } else if (menuInput.equals("2") || menuInput.equalsIgnoreCase("View Current Location")) {
                // TODO: View Current Location
            } else if (menuInput.equals("3") || menuInput.equalsIgnoreCase("View Inventory")) {
                // TODO: View Inventory
            } else if (menuInput.equals("4") || menuInput.equalsIgnoreCase("Upgrade House")) {
                // TODO: Upgrade House
            } else if (menuInput.equals("5") || menuInput.equalsIgnoreCase("Move Room")) {
                // TODO: Move Room
            } else if (menuInput.equals("6") || menuInput.equalsIgnoreCase("Edit Room")) {
                // TODO: Edit Room
            } else if (menuInput.equals("7") || menuInput.equalsIgnoreCase("Add Sim")) {
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
            } else if (menuInput.equals("11") || menuInput.equalsIgnoreCase("Action")) {
                // TODO: Action
            } else if (menuInput.equals("12") || menuInput.equalsIgnoreCase("Exit")) {
                // TODO: Exit
            } else if (menuInput.equals("13") || menuInput.equalsIgnoreCase("Beli barang")) {
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
            } else {
                // Invalid Input
                System.out.println("Aksi tidak dikenali!");
                System.out.println("");
            }
        }
    }
}