package TaskManagementLLD.models;

import java.time.LocalDate;
import java.util.UUID;

public class Comment {
    private String id;
    private String description;
    private LocalDate timeStamp;

    public Comment(String description){
        this.id = UUID.randomUUID().toString();
        this.timeStamp = LocalDate.now();
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }    
}
