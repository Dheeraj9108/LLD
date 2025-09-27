package HotelManagementSystemLLD.decorator;

public class Spa extends Amenities{

    public Spa(Bookable bookable) {
        super(bookable);
    }

    @Override
    public double getCost() {
        return super.getCost() + 30;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Spa";
    }

}
