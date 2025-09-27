package HotelManagementSystemLLD.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import HotelManagementSystemLLD.entites.Room;
import HotelManagementSystemLLD.specification.Specification;

public class RoomService {
    private List<Room> rooms;

    public RoomService() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public List<Room> findRooms(Specification spec){
        return rooms.stream().filter(spec::isStatisfied).collect(Collectors.toList());
    }
}
