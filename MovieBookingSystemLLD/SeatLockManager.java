package MovieBookingSystemLLD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import MovieBookingSystemLLD.entities.Seat;
import MovieBookingSystemLLD.entities.Show;
import MovieBookingSystemLLD.entities.User;
import MovieBookingSystemLLD.enums.SeatStatus;

public class SeatLockManager {

    private Map<Show,Map<Seat,String>> lockedSeats = new HashMap<>();
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public void lockSeats(Show show, User user, List<Seat> seats){
        synchronized(show){
            for(Seat seat : seats){
                if(seat.getStatus() != SeatStatus.AVAILABLE){
                    return;
                }
            }

            for(Seat seat : seats){
                seat.setStatus(SeatStatus.LOCKED);
            }   

            lockedSeats.computeIfAbsent(show, k->new HashMap<>());
            
            for(Seat seat:seats){
                lockedSeats.get(show).put(seat, user.getId());
            }

            service.schedule(()->unlockSeat(show, user, seats), (long) 0.5, TimeUnit.MILLISECONDS);
            System.out.println("Seats are locked");
        }
    }   

    public void unlockSeat(Show show, User user, List<Seat> seats){
        synchronized(show){
            Map<Seat,String> showLock = lockedSeats.get(show);
            if(!showLock.isEmpty()){
                for(Seat seat : seats){
                    if(showLock.containsKey(seat) && showLock.get(seat).equals(user.getId())){
                        showLock.remove(seat);
                        if(seat.getStatus() == SeatStatus.LOCKED){
                            seat.setStatus(SeatStatus.AVAILABLE);
                            System.out.println("Seat now available");
                        } else {
                            System.out.println("Seat booked");
                        }
                    }
                }
                if(showLock.isEmpty()){
                    lockedSeats.remove(show);
                }
            }
        }
    }

    public void shutdown(){
        service.shutdown();
        try {
            if(service.awaitTermination(5, TimeUnit.SECONDS)){
                service.shutdownNow();
            }
        } catch (Exception e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
