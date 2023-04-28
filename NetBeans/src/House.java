import java.util.List;
public class House {
    private Point coordinate;
    private List<Room> rooms;
    private int roomsTotal;

    public House(Point coordinate, List<Room> rooms, int roomsTotal) {
        this.coordinate = coordinate;
        this.rooms = rooms;
        this.roomsTotal = roomsTotal;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getRoomsTotal() {
        return roomsTotal;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setRoomTotal(int roomsTotal) {
        this.roomsTotal = roomsTotal;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
