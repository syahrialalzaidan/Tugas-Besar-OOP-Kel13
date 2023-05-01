import java.util.Arrays;

public class House {
    private Point coordinate;
    private Room[] rooms;
    private int roomCapacity = 100; 
    private int roomsTotal = 0;
    private String simName;
    private int upgradeHouseTime;
    private Room roomRoot;
    private Room newRoom;
    private String directionNewRoom;

    public House(Point coordinate , String simName) {
        this.coordinate = coordinate;
        this.rooms = new Room[100];
        this.simName = simName;
        this.roomRoot = null;
        this.newRoom = null;
        this.directionNewRoom = "";
        this.upgradeHouseTime = 0;
        Room firstroom = new Room("first-room");
        addRooms(firstroom);
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public Room getRoom(int index) {
        return rooms[index];
    }

    public void setRooms(Room[] rooms) {
        if (rooms.length > roomCapacity) {
            throw new IllegalArgumentException("rooms must be less than 100");
        }
        this.rooms = rooms;
    }

    public void increaseRoomCapacity() {
        int oldroomCapacity = roomCapacity;
        roomCapacity += 100;
        Room[] newRooms = new Room[roomCapacity];
        System.arraycopy(rooms, 0, newRooms, 0, oldroomCapacity);
        // for (int i = 0; i < rooms.length; i++) {
        //     newRooms[i] = rooms[i];
        // }
        rooms = newRooms;
    }

    public void addRooms(Room room)
    {
        if (roomsTotal >= roomCapacity) {
            // throw new IllegalArgumentException("rooms must be less than 100");
            increaseRoomCapacity();
        }
        this.rooms[roomsTotal] = room;
        roomsTotal++;
    }

    public int getRoomsTotal() {
        return roomsTotal;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public String getSimName() {
        return simName;
    }

    public void setSimName(String simName) {
        if (simName == null) {
            throw new IllegalArgumentException("simName must not be null");
        }
        this.simName = simName;
    }

    public int getUpgradeHouseTime() {
        return upgradeHouseTime;
    }

    public void setUpgradeHouseTime(int upgradeHouseTime) {
        this.upgradeHouseTime = upgradeHouseTime;
    }

    public void setRoomRoot(Room room)
    {
        this.roomRoot = room;
    }

    public void setNewRoom(Room room)
    {
        this.newRoom = room;
    }

    public Room getRoomRoot(Room room)
    {
        return this.roomRoot;
    }

    public Room getNewRoom(Room room)
    {
        return this.newRoom;
    }

    public String getDirectionNewRoom()
    {
        return this.directionNewRoom;
    }

    public void setDirectionNewRoom(String direction)
    {
        if(direction == "Up" || direction == "Down" || direction == "Right" || direction == "Left")
        {
            this.directionNewRoom = direction;
        }
        else
        {
            System.out.println("direction tidak valid");
        }
    }

    public void upgradeHouse(Room roomRoot , Room newRoom , String direction)
    {
        if(direction.equals("Up"))
        {
            roomRoot.setUpperRoom(newRoom);
            newRoom.setLowerRoom(roomRoot);
        }
        else if(direction.equals("Down"))
        {
            roomRoot.setLowerRoom(newRoom);
            newRoom.setUpperRoom(roomRoot);
        }
        else if(direction.equals("Left"))
        {
            roomRoot.setLeftRoom(newRoom);
            newRoom.setRightRoom(roomRoot);
        }
        else if(direction.equals("Right"))
        {
            roomRoot.setRightRoom(newRoom);
            newRoom.setLeftRoom(roomRoot);
        }
        else
        {
            throw new IllegalArgumentException("direction must be Up, Down, Left or Right");
        }
    }


    
    // public static void main(String[] args) {
    //     House house = new House(new Point(0, 0));
    //     Room room2 = new Room("room2");
    //     Room room3 = new Room("room3");
    //     Room room4 = new Room("room4");
    //     Room room5 = new Room("room5");
    //     Room room6 = new Room("room6");

    //     house.addRooms(room2);
    //     house.addRooms(room3);
    //     house.addRooms(room4);
    //     house.addRooms(room5);
    //     house.addRooms(room6);

    //     System.out.println(Arrays.toString(house.getRooms()));
    //     System.out.println(house.getRoomCapacity());

    // }
}
