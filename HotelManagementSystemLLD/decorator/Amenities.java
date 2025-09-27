package HotelManagementSystemLLD.decorator;

public abstract class Amenities implements Bookable{
    private final Bookable bookable;

    public Amenities(Bookable bookable) {
        this.bookable = bookable;
    }

    @Override
    public double getCost() {
        return bookable.getCost();
        
    }

    @Override
    public String getDescription() {
        return bookable.getDescription();
    }
}
