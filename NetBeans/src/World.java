import java.util.*;
public class World {
    private List<House> house;
    private static int houseTotal = 0;
    private Point dimensions = new Point(64, 64);

    World(List<House> house){
        this.house = house;
    }
    public List<House> getHouse(){
        return house;
    }

    public int getHouseTotal(){
        return houseTotal;
    }

    public Point getDimensions(){
        return dimensions;
    }
    public void setHouse(List<House> house){
        this.house = house;
    }

    public void addHouse(House house){
        this.house.add(house);
        houseTotal++;
    }
   
}