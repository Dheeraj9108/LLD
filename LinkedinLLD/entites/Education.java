package LinkedinLLD.entites;

import java.time.LocalDate;

public class Education {
    private String colleg;
    private LocalDate starDate;
    private LocalDate endDate;
    
    public Education(String colleg, LocalDate starDate, LocalDate endDate) {
        this.colleg = colleg;
        this.starDate = starDate;
        this.endDate = endDate;
    }

    public String getColleg() {
        return colleg;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
        
}
