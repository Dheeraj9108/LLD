package HotelManagementSystemLLD.entites;

import java.util.UUID;

import HotelManagementSystemLLD.enums.RoomStyle;
import HotelManagementSystemLLD.enums.RoomType;
import HotelManagementSystemLLD.state.Available;
import HotelManagementSystemLLD.state.RoomState;

public class Room {
    private String roomId;
    private RoomType type;
    private RoomStyle style;
    private double price;
    private RoomState state;

    public Room(RoomType type, RoomStyle style, double price) {
        this.roomId = UUID.randomUUID().toString();
        this.type = type;
        this.style = style;
        this.price = price;
        this.state = new Available();
    }

    public void setState(RoomState state){
        this.state = state;
    }

    public void book() {
        state.book(this);
    }

    public void checkIn() {
        state.checkIn(this);
    }

    public void checkOut() {
        state.checkOut(this);
    }

    public String getRoomId() {
        return roomId;
    }

    public RoomType getType() {
        return type;
    }

    public RoomStyle getStyle() {
        return style;
    }

    public double getPrice() {
        return price;
    }

    public RoomState getState() {
        return state;
    }

}
