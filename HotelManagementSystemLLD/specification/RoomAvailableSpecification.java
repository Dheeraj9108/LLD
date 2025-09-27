package HotelManagementSystemLLD.specification;

import HotelManagementSystemLLD.entites.Room;
import HotelManagementSystemLLD.state.Available;

public class RoomAvailableSpecification extends AbstractSpecification{

    @Override
    public boolean isStatisfied(Room item) {
        return item.getState() instanceof Available;
    }
    
}
