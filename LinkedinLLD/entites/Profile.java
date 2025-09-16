package LinkedinLLD.entites;

import java.util.List;
import java.util.Set;

public class Profile {
    private Set<String> skills;
    private String summary;
    private List<Education> educations;
    private List<Experience> experiences;
    
    public Set<String> getSkills() {
        return skills;
    }
    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public List<Education> getEducations() {
        return educations;
    }
    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }
    public List<Experience> getExperiences() {
        return experiences;
    }
    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
    
}
