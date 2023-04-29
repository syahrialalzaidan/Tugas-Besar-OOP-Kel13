import java.util.*;
public class World {
    private List<House> house;
    private static int houseTotal = 0;
    private int[][] pointHouse;

    World(){
        house = new ArrayList<House>();
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
}