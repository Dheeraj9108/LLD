package CourseRegisterationSystemLLD.entities;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private String id;
    private String name;
    private Set<CourseOffering> registeredCourses;
    private Set<Course> completedCourses;
    
    public Student(String studentId,String name) {
        this.id = studentId;
        this.name = name;
        registeredCourses = new HashSet<>();
        completedCourses = new HashSet<>();
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Set<CourseOffering> getRegisteredCourses() {
        return registeredCourses;
    }

    public void drop(CourseOffering offering){
        registeredCourses.remove(offering);
    }

    public void addCourse(CourseOffering offering){
        this.registeredCourses.add(offering);
    }

    public void addCompletedCourse(Course course){
        completedCourses.add(course);
    }

    public Set<Course> getCompletedCourses() {
        return completedCourses;
    }
}
