package TaskManagementLLD.models;

import java.time.LocalDate;

public class ActivityLog {
    private String description;
    private LocalDate timeStamp;

    public ActivityLog(String description){
        this.description = description;
        this.timeStamp = LocalDate.now();
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }
}
