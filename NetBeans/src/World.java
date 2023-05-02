import java.util.*;
public class World {
    private List<House> house;
    private static int houseTotal = 0;
    private int[][] pointHouse = new int[64][64];
    private int time;
    private int day; 

    World(){
        house = new ArrayList<House>();
        time = 0;
        day = 0;
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                pointHouse[i][j] = 0;
            }
        }
    }
    public List<House> getHouse(){
        return house;
    }

    public int getHouseTotal(){
        return houseTotal;
    }

    public int[][] getPointHouse(){
        return pointHouse;
    }

    public int getTime() {
        return time;
    }

    public void setHouse(List<House> house){
        this.house = house;
    }

    public void addHouse(House house){
        if(pointHouse[house.getCoordinate().getX()][house.getCoordinate().getY()] != 0){
            throw new IllegalArgumentException("House already exist");
        }
        else{
            this.house.add(house);
            pointHouse[house.getCoordinate().getX()][house.getCoordinate().getY()] = 1;
            houseTotal++;
        }
    }

    public boolean isHouseExist(int x, int y){
        if(pointHouse[x][y] == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public void runTime(int time){
        int now = this.time + time;
            for (Sim s : GameManager.getSimList()){
                if (this.time < 600 && now >= 600){
                    if (s.getDailySleep() < 180){
                        s.setHeath(s.getHeath()-5);
                        s.setMood(s.getMood()-5);
                        System.out.println("Status mood dah health berkurang karena kurang tidur");
                }}
                if (s.getAfterEating()){
                    s.setKebelet(s.getKebelet()+time);
                }
                if (s.getKebelet()>=240){
                    s.setHeath(s.getHeath()-5);
                    s.setMood(s.getMood()-5);
                    s.setKebelet(s.getKebelet()-240);
                    System.out.println("Status mood dah health berkurang karena belum buang air");
                }
                if (s.getBerkunjung()!=0){
                    s.setBerkunjung(s.getBerkunjung()+time);
                    if ((s.getBerkunjung()-1)%30==0){
                        int efek = (s.getBerkunjung()-1)/30;
                        s.setMood(s.getMood()+10*efek);
                        s.setFullness(s.getFullness()-10*efek);
                        s.setBerkunjung(s.getBerkunjung()-30*efek);
                        System.out.println("Akibat berkunjung status mood bertambah dan status health berkurang ");
                    }
                }
                for (Pair<String,Integer,Integer> pair : s.getItemOrder()){
                    pair.setC(pair.getC()-time);
                    if (pair.getC()<=0){
                        s.addInventoryitems(new Items(pair.getA()));
                    }
                }
                for (Pair<String,Integer,Integer> pair : s.getFoodOrder()){
                    pair.setC(pair.getC()-time);
                    if (pair.getC()<=0){
                        s.addInventoryfood(new Food(pair.getA()));
                    }
                }

            }
        for (House rumah : house){
            if (rumah.getUpgradeHouseTime()!=0){
                rumah.setUpgradeHouseTime(rumah.getUpgradeHouseTime()-time);
                if (rumah.getUpgradeHouseTime()<=0){
                    rumah.upgradeHouse(rumah.getRoomRoot(), rumah.getNewRoom(), rumah.getDirectionNewRoom());
                    rumah.setUpgradeHouseTime(0);
                }
            }
        }

        this.time = now;
        resetDay();
    }

    public void resetDay(){
        if (time >= 720){
            time-=720;
            day++;
            for (Sim s : GameManager.getSimList()){
                s.resetSim();
            }
        }
    }
}
