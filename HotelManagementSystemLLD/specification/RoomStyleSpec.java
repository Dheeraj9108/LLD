package HotelManagementSystemLLD.specification;

import HotelManagementSystemLLD.entites.Room;
import HotelManagementSystemLLD.enums.RoomStyle;

public class RoomStyleSpec extends AbstractSpecification{
    private final RoomStyle style;

    public RoomStyleSpec(RoomStyle style) {
        this.style = style;
    }

    @Override
    public boolean isStatisfied(Room room) {
        return room.getStyle() == style;
    }
    
}
