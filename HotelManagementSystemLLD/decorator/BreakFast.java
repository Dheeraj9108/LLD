package HotelManagementSystemLLD.decorator;

public class BreakFast extends Amenities{

    public BreakFast(Bookable bookable) {
        super(bookable);
    }

    @Override
    public double getCost() {
        return super.getCost() + 120;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with breakfast";
    }
    
}
