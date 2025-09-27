package HotelManagementSystemLLD.specification;

import HotelManagementSystemLLD.entites.Room;
import HotelManagementSystemLLD.enums.RoomType;

public class RoomTypeSpec extends AbstractSpecification{

    private final RoomType type;

    public RoomTypeSpec(RoomType type) {
        this.type = type;
    }

    @Override
    public boolean isStatisfied(Room room) {
        return room.getType() == type;
    }

}
