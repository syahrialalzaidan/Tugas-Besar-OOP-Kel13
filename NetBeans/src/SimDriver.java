import java.util.ArrayList;
import java.util.Scanner;

public class SimDriver {

    public static void main(String[] args) throws Exception{
        Sim currentSim = null;
        World world = null;

        //House currentHouse = null;
        Room currentRoom = null;
        world = new World();
        String namaSim = "asd";
        // Random Posisi Rumah Pertama
        int max = 63;
        int min = 0;
        int x = (int) (Math.random() * (max - min + 1) + min);
        int y = (int) (Math.random() * (max - min + 1) + min);

        Point coordinate = new Point(x, y);
        House firstHouse = new House(coordinate , namaSim);

        // membuat Sim pertama
        Sim firstSim = new Sim(namaSim, firstHouse, world);

        // menset upgradeHouseTime baru untuk sim pertama


        
        // Memasukan Sim kedalam SimList
        GameManager.addSim(namaSim, world, firstHouse);

        // currentSim mengacu ke firstSim
        currentSim = GameManager.getSimList().get(0);

        // Memasukan House ke dalam World
        world.addHouse(currentSim.getHouse());
        currentSim.watchingTV(30);
        //Thread.sleep(10000);
        currentSim.viewSimInfo();
        currentSim.viewClock();





    }
}

