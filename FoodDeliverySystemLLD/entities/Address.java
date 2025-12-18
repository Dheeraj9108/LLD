package FoodDeliverySystemLLD.entities;

public class Address {
    private String street;
    private String city;
    private String zipCode;
    private Double longitute;
    private Double latitude;
    public Address(String street, String city, String zipCode, Double longitute, Double latitude) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.longitute = longitute;
        this.latitude = latitude;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getZipCode() {
        return zipCode;
    }
    public Double getLongitute() {
        return longitute;
    }
    public Double getLatitude() {
        return latitude;
    }

    public Double distanceTo(Address other){
        Double latDiff = this.latitude - other.latitude; 
        Double lonDiff = this.latitude - other.longitute;
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff); 
    } 
}
