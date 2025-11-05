package MovieBookingSystemLLD.entities;

import MovieBookingSystemLLD.enums.SeatStatus;
import MovieBookingSystemLLD.enums.SeatType;

public class Seat {
    private String id;
    private SeatType type;
    private SeatStatus status;
    private int row;
    private int col;
    public Seat(String id, SeatType type, int row, int col) {
        this.id = id;
        this.type = type;
        this.status = SeatStatus.AVAILABLE;
        this.row = row;
        this.col = col;
    }
    public void setStatus(SeatStatus status){
        this.status = status;
    }
    public String getId() {
        return id;
    }
    public SeatType getType() {
        return type;
    }
    public SeatStatus getStatus() {
        return status;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
