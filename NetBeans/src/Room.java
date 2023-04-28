import java.util.HashMap;

public class Room {
    private String roomName;
    private HashMap<String, Point> objects;
    private int[][] space;
    private Room rightRoom;
    private Room leftRoom;
    private Room upperRoom;
    private Room lowerRoom;

    public Room(String roomName, HashMap<String, Point> objects, int[][] space, Room rightRoom, Room leftRoom, Room upperRoom, Room lowerRoom) {
        this.roomName = roomName;
        this.objects = objects;
        this.space = space;
        this.rightRoom = rightRoom;
        this.leftRoom = leftRoom;
        this.upperRoom = upperRoom;
        this.lowerRoom = lowerRoom;
    }

    public HashMap<String, Point> getObjects() {
        return objects;
    }

    public int[][] getSpace() {
        return space;
    }

    public String getRoomName() {
        return roomName;
    }

    public Room getRightRoom() {
        return rightRoom;
    }

    public Room getLeftRoom() {
        return leftRoom;
    }

    public Room getUpperRoom() {
        return upperRoom;
    }

    public Room getLowerRoom() {
        return lowerRoom;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setObjects(HashMap<String, Point> objects) {
        this.objects = objects;
    }

    public void setSpace(int[][] space) {
        this.space = space;
    }

    public void setRightRoom(Room rightRoom) {
        this.rightRoom = rightRoom;
    }

    public void setLeftRoom(Room leftRoom) {
        this.leftRoom = leftRoom;
    }

    public void setUpperRoom(Room upperRoom) {
        this.upperRoom = upperRoom;
    }

    public void setLowerRoom(Room lowerRoom) {
        this.lowerRoom = lowerRoom;
    }

    public void addObject(String objectName, Point coordinate) {
        objects.put(objectName, coordinate);
    }

    public void removeObject(String objectName) {
        objects.remove(objectName);
    }

    public void moveObject(String objectName, Point coordinate) {
        objects.replace(objectName, coordinate);
    }

    public Boolean checkAvailbililtySpace (Point coordinate) {
        if (space[coordinate.getX()][coordinate.getY()] == 0) {
            return true;
        } else {
            return false;
        }
    }


}