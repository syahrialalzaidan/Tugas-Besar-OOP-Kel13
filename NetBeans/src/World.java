import java.util.*;
public class World {
    private List<House> house;
    private static int houseTotal = 0;
    private int[][] pointHouse;
    private int time;
    private int day; 

    World(){
        house = new ArrayList<House>();
        time = 0;
        day = 0;
    }
    public List<House> getHouse(){
        return house;
    }

    public int getHouseTotal(){
        return houseTotal;
    }

    pub

    public int[][] getPointHouse(){
        return pointHouse;
    }

    public void setHouse(List<House> house){
        this.house = house;
    }

    public void addHouse(House house){
        boolean isExist = false;

        for (int i = 0; i < pointHouse.length; i++) {
                if (pointHouse[i][0] == house.getCoordinate().getX() && pointHouse[i][1] == house.getCoordinate().getY()) {
                    isExist = true;
        }
    }
        if(isExist){
            throw new IllegalArgumentException("House already exist");
        }
        else{
            this.house.add(house);
            pointHouse[houseTotal-1][0] = house.getCoordinate().getX();
            pointHouse[houseTotal-1][1] = house.getCoordinate().getY();
            houseTotal++;
        }
    }

    public void runTime(int time){
        int now = this.time + time;
            for (Sim s : GameManager.getSimList()){
                if (this.time < 600 && now >= 600){
                    if (s.getDailySleep() < 180){
                        s.setHeath(s.getHeath()-5);
                        s.setMood(s.getMood()-5);
                }}
                if (s.getAfterEating()){
                    s.setKebelet(s.getKebelet()+time);
                }
                if (s.getKebelet()>=240){
                    s.setHeath(s.getHeath()-5);
                    s.setMood(s.getMood()-5);
                    s.setKebelet(s.getKebelet()-240);
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