package mypack;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> searchRooms(String category) {
        List<Room> results = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCategory().equals(category)) {
                results.add(room);
            }
        }
        return results;
    }

    public Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
