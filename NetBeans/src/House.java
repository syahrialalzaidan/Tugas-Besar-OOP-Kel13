import java.util.Arrays;
import java.util.*;

public class House {
    private Point coordinate;
    private HashMap<Point,Room> listRoom;
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
        this.listRoom = new HashMap<Point, Room>();
        this.rooms = new Room[100];
        this.simName = simName;
        this.roomRoot = null;
        this.newRoom = null;
        this.directionNewRoom = "";
        this.upgradeHouseTime = 0;
        Room firstroom = new Room("first-room");
        addRooms(firstroom);
        addToListRoom(firstroom.getRoomPoint(), firstroom);
    }

    public HashMap<Point,Room> getListRoom()
    {
        return this.listRoom;
    }

    public Point getPointFromRoom(Room room)
    {
        for(Point point : this.listRoom.keySet())
        {
            if(this.listRoom.get(point) == room)
            {
                return point;
            }
        }
        System.out.println("Room not found");
        return null;
    }

    public Room getRoomFromPoint(Point point)
    {
        return this.listRoom.get(point);
    }

    public void addToListRoom(Point point, Room room)
    {
        this.listRoom.put(point, room);
    }


    public Boolean upperRoomExist(Room rootRoom)
    {
        Point point = new Point(rootRoom.getRoomPoint().getX(), rootRoom.getRoomPoint().getY() + 1);
        if(this.listRoom.containsKey(point))
        {
            return true;
        }
        return false;
    }

    public Boolean lowerRoomExist(Room rootRoom)
    {
        Point point = new Point(rootRoom.getRoomPoint().getX(), rootRoom.getRoomPoint().getY() - 1);
        if(this.listRoom.containsKey(point))
        {
            return true;
        }
        return false;
    }

    public Boolean rightRoomExist(Room rootRoom)
    {
        Point point = new Point(rootRoom.getRoomPoint().getX() + 1, rootRoom.getRoomPoint().getY());
        if(this.listRoom.containsKey(point))
        {
            return true;
        }
        return false;
    }

    public Boolean leftRoomExist(Room rootRoom)
    {
        Point point = new Point(rootRoom.getRoomPoint().getX() - 1, rootRoom.getRoomPoint().getY());
        if(this.listRoom.containsKey(point))
        {
            return true;
        }
        return false;
    }

    public Boolean isRoomExist(String roomName)
    {
        for(Point point : this.listRoom.keySet())
        {
            if(this.listRoom.get(point).getRoomName().equalsIgnoreCase(roomName))
            {
                System.out.println("Room Sudah Ada");
                System.out.println("Silahkan Pilih Room Lain");
                return true;
            }
        }
        return false;
        //System.out.println("Room Not Exist");
    }

    public Room getUpperRoom(Room rootRoom)
    {
        Point point = new Point(rootRoom.getRoomPoint().getX(), rootRoom.getRoomPoint().getY() + 1);
        return this.listRoom.get(point);
    }

    public Room getLowerRoom(Room rootRoom)
    {
        Point point = new Point(rootRoom.getRoomPoint().getX(), rootRoom.getRoomPoint().getY() - 1);
        return this.listRoom.get(point);
    }

    public Room getRightRoom(Room rootRoom)
    {
        Point point = new Point(rootRoom.getRoomPoint().getX() + 1, rootRoom.getRoomPoint().getY());
        return this.listRoom.get(point);
    }

    public Room getLeftRoom(Room rootRoom)
    {
        Point point = new Point(rootRoom.getRoomPoint().getX() - 1, rootRoom.getRoomPoint().getY());
        return this.listRoom.get(point);
    }

    
    public Boolean isAvailableAroundRoom(Room roomRoot)
    {
        /* Mengecek Apakah Ada Ruang Tersedia disekitar Room */

        Point up = new Point(roomRoot.getRoomPoint().getX(), roomRoot.getRoomPoint().getY() + 1);
        Point down = new Point(roomRoot.getRoomPoint().getX(), roomRoot.getRoomPoint().getY() - 1);
        Point right = new Point(roomRoot.getRoomPoint().getX() + 1, roomRoot.getRoomPoint().getY());
        Point left = new Point(roomRoot.getRoomPoint().getX() - 1, roomRoot.getRoomPoint().getY());

        if(this.listRoom.containsKey(up) && this.listRoom.containsKey(down) && this.listRoom.containsKey(right) && this.listRoom.containsKey(left))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void printAroundRoom(Room room)
    {
        for(Point point : this.listRoom.keySet())
        {
            if(this.listRoom.get(point) == room)
            {
                // Cek Room Atas
                if(upperRoomExist(room))
                {
                    Point up = new Point(point.getX(), point.getY() + 1);
                    System.out.println("Up : " + this.listRoom.get(up).getRoomName());
                }
                else
                {
                    System.out.println("Up : -");
                }

                // Cek Room Bawah
                if(lowerRoomExist(room))
                {
                    Point down = new Point(point.getX(), point.getY() - 1);
                    System.out.println("Down : " + this.listRoom.get(down).getRoomName());
                }
                else
                {
                    System.out.println("Down : -");
                }

                // Cek Room Kanan
                if(rightRoomExist(room))
                {
                    Point right = new Point(point.getX() + 1, point.getY());
                    System.out.println("Right : " + this.listRoom.get(right).getRoomName());
                }
                else
                {
                    System.out.println("Right : -");
                }

                // Cek Room Kiri
                if(leftRoomExist(room))
                {
                    Point left = new Point(point.getX() - 1, point.getY());
                    System.out.println("Left : " + this.listRoom.get(left).getRoomName());
                }
                else
                {
                    System.out.println("Left : -");
                }
            }
        }
        System.out.println("");
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

    public Room getRoomRoot()
    {
        return this.roomRoot;
    }

    public Room getNewRoom()
    {
        return this.newRoom;
    }

    public String getDirectionNewRoom()
    {
        return this.directionNewRoom;
    }

    public void setDirectionNewRoom(String direction)
    {
        if(direction.equalsIgnoreCase("Up") || direction.equalsIgnoreCase("Down") || direction.equalsIgnoreCase("Right") || direction.equalsIgnoreCase("Left"))
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
            Point newRoomPoint = new Point(roomRoot.getRoomPoint().getX(), roomRoot.getRoomPoint().getY() + 1);
            newRoom.setRoomPoint(newRoomPoint.getX() , newRoomPoint.getY());
            this.listRoom.put(newRoomPoint, newRoom);
            addRooms(newRoom);
        }
        else if(direction.equals("Down"))
        {
            Point newRoomPoint = new Point(roomRoot.getRoomPoint().getX(), roomRoot.getRoomPoint().getY() - 1);
            newRoom.setRoomPoint(newRoomPoint.getX() , newRoomPoint.getY());
            this.listRoom.put(newRoomPoint, newRoom);
            addRooms(newRoom);
        }
        else if(direction.equals("Left"))
        {
            Point newRoomPoint = new Point(roomRoot.getRoomPoint().getX() - 1, roomRoot.getRoomPoint().getY());
            newRoom.setRoomPoint(newRoomPoint.getX() , newRoomPoint.getY());
            this.listRoom.put(newRoomPoint, newRoom);
            addRooms(newRoom);
        }
        else if(direction.equals("Right"))
        {
            Point newRoomPoint = new Point(roomRoot.getRoomPoint().getX() + 1, roomRoot.getRoomPoint().getY());
            newRoom.setRoomPoint(newRoomPoint.getX() , newRoomPoint.getY());
            this.listRoom.put(newRoomPoint, newRoom);
            addRooms(newRoom);
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
