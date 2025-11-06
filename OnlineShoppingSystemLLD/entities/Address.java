package OnlineShoppingSystemLLD.entities;

public class Address {
    private String state;
    private String city;
    private String street;
    private String zipcode;
    public Address(String state, String city, String street, String zipcode) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
    public String getState() {
        return state;
    }
    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public String getZipcode() {
        return zipcode;
    }
}
