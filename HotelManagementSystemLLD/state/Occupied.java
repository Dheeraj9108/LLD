package HotelManagementSystemLLD.state;

import HotelManagementSystemLLD.entites.Room;

public class Occupied implements RoomState {

    @Override
    public void book(Room room) {
    }

    @Override
    public void checkIn(Room room) {
    }

    @Override
    public void checkOut(Room room) {
        System.out.println("Check-Out Success");
        room.setState(new Available());
    }

    @Override
    public void maintainance(Room room) {
    }
    
}
