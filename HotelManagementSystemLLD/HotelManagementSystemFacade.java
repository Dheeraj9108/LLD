package HotelManagementSystemLLD;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import HotelManagementSystemLLD.decorator.Bookable;
import HotelManagementSystemLLD.decorator.BreakFast;
import HotelManagementSystemLLD.decorator.RoomBooking;
import HotelManagementSystemLLD.decorator.Spa;
import HotelManagementSystemLLD.entites.Booking;
import HotelManagementSystemLLD.entites.Guest;
import HotelManagementSystemLLD.entites.Room;
import HotelManagementSystemLLD.enums.RoomStyle;
import HotelManagementSystemLLD.enums.RoomType;
import HotelManagementSystemLLD.service.BookingService;
import HotelManagementSystemLLD.service.PaymentService;
import HotelManagementSystemLLD.service.RoomService;
import HotelManagementSystemLLD.specification.RoomAvailableSpecification;
import HotelManagementSystemLLD.specification.RoomStyleSpec;
import HotelManagementSystemLLD.specification.RoomTypeSpec;
import HotelManagementSystemLLD.specification.Specification;

public class HotelManagementSystemFacade {
    private RoomService roomService;
    private BookingService bookingService;
    private PaymentService paymentService;
    
    public HotelManagementSystemFacade(RoomService roomService, BookingService bookingService,
            PaymentService paymentService) {
        this.roomService = roomService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    public Booking createBooking(RoomType type, RoomStyle style, List<String> amenities, Guest guest, LocalDate starDate, LocalDate endDate){
        Specification spec = new RoomAvailableSpecification()
                                .and(new RoomTypeSpec(type))
                                .and(new RoomStyleSpec(style));

        Optional<Room> room = roomService.findRooms(spec).stream().findFirst();

        if(room.isPresent()){
            Room availableRoom = room.get();

            Booking booking = bookingService.createBooking(availableRoom, guest, starDate, endDate);

            Bookable bookable = new RoomBooking(availableRoom);
            for(String amenity : amenities){
                if("breakfast".equals(amenity)){
                    bookable = new BreakFast(bookable);
                } else if("spa".equals(amenity)){
                    bookable = new Spa(bookable);
                }
            }

            System.out.println("Payment " +bookable.getCost() + "     "+ bookable.getDescription());

            paymentService.processPayment(bookable.getCost());

            return booking;
        } else {
            System.out.println("No rooms found");
            return null;
        }
    }

}
