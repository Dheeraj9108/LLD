package CourseRegisterationSystemLLD.entities;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record TimeSlot(DayOfWeek week, LocalTime starTime, LocalTime endTime) {

    public boolean overlaps(TimeSlot other){
        return this.week == other.week &&
                this.starTime.isBefore(other.endTime) &&
                this.endTime.isAfter(other.starTime);
    }
} 
