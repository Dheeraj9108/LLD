package HotelManagementSystemLLD.state;

import HotelManagementSystemLLD.entites.Room;

public interface RoomState {
    public void book(Room room);
    public void checkIn(Room room);
    public void checkOut(Room room);
    public void maintainance(Room room);
}
