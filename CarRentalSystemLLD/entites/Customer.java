package CarRentalSystemLLD.entites;

public class Customer {
    private String name;
    private String contactInfo;
    private String licenseNumber;

    public Customer(String name, String contactInfo, String licenseNumber) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.licenseNumber = licenseNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}
