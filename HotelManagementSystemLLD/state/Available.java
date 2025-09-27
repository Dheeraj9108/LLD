package HotelManagementSystemLLD.state;

import HotelManagementSystemLLD.entites.Room;

public class Available implements RoomState {

    @Override
    public void book(Room room) {
        System.out.println("Room booked Successfully");
        room.setState(new Occupied());
    }

    @Override
    public void checkIn(Room room) {
        System.out.println("Room Checked-In Successfully");
        room.setState(new Occupied());
    }

    @Override
    public void checkOut(Room room) {
    }

    @Override
    public void maintainance(Room room) {
    }

}
