package UberLLD.entities;

public class Location {
    private final double longitude;
    private final double latitude;

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double distanceTo(Location other) {
        double dx = this.longitude - other.longitude;
        double dy = this.latitude - other.latitude;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
