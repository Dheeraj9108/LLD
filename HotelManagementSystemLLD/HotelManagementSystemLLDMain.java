package HotelManagementSystemLLD;

import java.time.LocalDate;
import java.util.List;

import HotelManagementSystemLLD.entites.Guest;
import HotelManagementSystemLLD.entites.Room;
import HotelManagementSystemLLD.enums.RoomStyle;
import HotelManagementSystemLLD.enums.RoomType;
import HotelManagementSystemLLD.observer.Email;
import HotelManagementSystemLLD.observer.Sms;
import HotelManagementSystemLLD.service.BookingService;
import HotelManagementSystemLLD.service.PaymentService;
import HotelManagementSystemLLD.service.RoomService;

public class HotelManagementSystemLLDMain{
    public static void main(String[] args) {
        RoomService roomService = new RoomService();
        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();

        bookingService.addObserver(new Email());
        bookingService.addObserver(new Sms());
        HotelManagementSystemFacade facade = new HotelManagementSystemFacade(roomService, bookingService, paymentService);

        roomService.addRoom(new Room(RoomType.SINGLE, RoomStyle.STANDARD, 100));
        roomService.addRoom(new Room(RoomType.SINGLE, RoomStyle.STANDARD, 200));

        Guest g1 = new Guest("Alice", "alice@gmail.com");
        Guest g2 = new Guest("Bob", "bob@gmail.com");
        facade.createBooking(RoomType.SINGLE, RoomStyle.STANDARD, List.of("spa"), g1, LocalDate.now(), LocalDate.now().plusDays(3));
        facade.createBooking(RoomType.SINGLE, RoomStyle.STANDARD, List.of("spa"), g2, LocalDate.now(), LocalDate.now().plusDays(3));
    }
}