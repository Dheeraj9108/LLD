package UberLLD.entities;

public class Rider extends User{

    public Rider(String name, String contact) {
        super(name, contact);
    }

    @Override
    public void onUpdate(Trip trip) {
         System.out.println("----[Notification] Rider------");
        System.out.printf("%s is the Trip status \n", trip.getStatus());
    }
    
}
