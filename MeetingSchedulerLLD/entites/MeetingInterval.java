package MeetingSchedulerLLD.entites;

import java.time.LocalDateTime;

public class MeetingInterval {
    private LocalDateTime start;
    private LocalDateTime end;
    public MeetingInterval(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }
    public LocalDateTime getStart() {
        return start;
    }
    public LocalDateTime getEnd() {
        return end;
    }
}
