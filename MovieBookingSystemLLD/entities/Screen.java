package MovieBookingSystemLLD.entities;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String id;
    private List<Seat> seats;
    public Screen(String id) {
        seats = new ArrayList<>();
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public List<Seat> getSeats() {
        return seats;
    }
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }
    
}
