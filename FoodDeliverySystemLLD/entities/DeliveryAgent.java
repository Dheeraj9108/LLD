package FoodDeliverySystemLLD.entities;

public class DeliveryAgent extends User{

    private boolean isAvailable;
    private Address address;

    public DeliveryAgent(String name, String phone, Address address) {
        super(name, phone);
        this.address = address;
        isAvailable = true;
    }

    public void setAvailability(boolean available){
        this.isAvailable = available;
    }

    @Override
    public void onUpdate(Order order) {
        System.out.printf("Notification to Agent %s :: Order Status %s \n", getName(), order.getStatus());
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Address getAddress() {
        return address;
    }
    
}
