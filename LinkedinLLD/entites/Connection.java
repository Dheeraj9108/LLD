package LinkedinLLD.entites;

import java.time.LocalDateTime;
import java.util.UUID;

import LinkedinLLD.enums.Connectiontype;

public class Connection {
    private String id;
    private Member from;
    private Member to;
    private Connectiontype status;
    private LocalDateTime requestedAt;
    private LocalDateTime acceptedAt;

    public Connection(Member from, Member to){
        this.id = UUID.randomUUID().toString();
        this.from = from;
        this.to = to;
        this.status = Connectiontype.PENDING;
        this.requestedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Member getFrom() {
        return from;
    }

    public Member getTo() {
        return to;
    }

    public Connectiontype getType() {
        return status;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public LocalDateTime getAcceptedAt() {
        return acceptedAt;
    }

    public void setStatus(Connectiontype status){
        this.status = status;
    }
}
