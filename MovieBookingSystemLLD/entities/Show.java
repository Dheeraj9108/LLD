package MovieBookingSystemLLD.entities;

import java.time.LocalDateTime;

import MovieBookingSystemLLD.strategry.PricingStrategry;

public class Show {
    private String id;
    private Movie movie;
    private Screen screen;
    private LocalDateTime date;
    private PricingStrategry pricingStrtergy;
    public Show(String id, Movie movie, Screen screen, LocalDateTime date, PricingStrategry pricingStrtergy) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.date = date;
        this.pricingStrtergy = pricingStrtergy;
    }
    public String getId() {
        return id;
    }
    public Movie getMovie() {
        return movie;
    }
    public Screen getScreen() {
        return screen;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public PricingStrategry getPricingStrtergy() {
        return pricingStrtergy;
    }
}
