package LinkedinLLD.entites;

import java.time.LocalDate;

public class Experience {
    private String title;
    private String company;
    private LocalDate starDate;
    private LocalDate endDate;
    
    public Experience(String title, String company, LocalDate starDate, LocalDate endDate) {
        this.title = title;
        this.company = company;
        this.starDate = starDate;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    
}
