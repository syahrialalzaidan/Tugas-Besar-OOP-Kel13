import java.util.Arrays;

public class House {
    private Point coordinate;
    private Room[] rooms;
    private int roomCapacity = 100; 
    public static int roomsTotal = 0;

    public House(Point coordinate) {
        this.coordinate = coordinate;
        this.rooms = new Room[100];
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

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public static void main(String[] args) {
        House house = new House(new Point(0, 0));
        Room room2 = new Room("room2");
        Room room3 = new Room("room3");
        Room room4 = new Room("room4");
        Room room5 = new Room("room5");
        Room room6 = new Room("room6");

        house.addRooms(room2);
        house.addRooms(room3);
        house.addRooms(room4);
        house.addRooms(room5);
        house.addRooms(room6);

        System.out.println(Arrays.toString(house.getRooms()));
        System.out.println(house.getRoomCapacity());

    }
}
