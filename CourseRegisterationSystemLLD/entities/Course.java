package CourseRegisterationSystemLLD.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Course {
    private String id;
    private String code;
    private String title;
    private Set<Course> pre;
    
    public Course(String code, String title) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
        this.title = title;
        pre = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public Set<Course> getPre() {
        return pre;
    }
    
    public void addPrerequisite(Course course){
        pre.add(course);
    }
}
