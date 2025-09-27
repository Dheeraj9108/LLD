package HotelManagementSystemLLD.specification;

import HotelManagementSystemLLD.entites.Room;

public class AndSpecification extends AbstractSpecification{

    private final Specification spec1;
    private final Specification spec2;

    public AndSpecification(Specification spec1, Specification spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }   

    @Override
    public boolean isStatisfied(Room room) {
        return spec1.isStatisfied(room) && spec2.isStatisfied(room);
    }
    
}
