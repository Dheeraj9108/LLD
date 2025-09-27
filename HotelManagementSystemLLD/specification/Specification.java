package HotelManagementSystemLLD.specification;

import HotelManagementSystemLLD.entites.Room;

public interface Specification {
    public boolean isStatisfied(Room room);
    public Specification and(Specification spec);
}
