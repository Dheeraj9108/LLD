package PubSubLLD.entites;

import java.time.Instant;

public class Message {
    private String payload;
    private Instant timeStamp;

    public Message(String payload){
        this.payload = payload;
        timeStamp = Instant.now();
    }

    public String getPayload() {
        return payload;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }
}
