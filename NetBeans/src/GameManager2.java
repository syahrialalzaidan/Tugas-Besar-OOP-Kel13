import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class GameManager2 {
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

    public Sim getCurrentSim() {
        return sim;
    }

    public static void help() {
        // Isi Help Disini
        // ---------------
    }

    public static void exit() {
        // Isi Exit Disini
        // ---------------
    }

    public static void main(String[] args) {
        List<Sim> simList = new ArrayList<>();
        Sim currentSim;
        World world;
        House currentHouse;
        Room currentRoom;
        List<House> listhouse = new ArrayList<>();

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
                world = new World(listhouse);

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
                currentRoom = currentHouse.getRooms()[0];
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
        input.close();
    }

}
