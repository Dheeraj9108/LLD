package MovieBookingSystemLLD.enums;

public enum SeatType {
    REGULAR(50.0),
    PREMIUM(70.0);

    private final double value;

    private SeatType(double value){
        this.value = value;
    }

    public double getPrice(){
        return this.value;
    }
}
