package CourseRegisterationSystemLLD.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import CourseRegisterationSystemLLD.entities.Course;
import CourseRegisterationSystemLLD.entities.CourseOffering;

public class CourseRepo {
     private final Map<String,Course> courses;
     private final Map<String,CourseOffering> offerings;
    private static CourseRepo INSTANCE;
    
    public void saveCourse(Course course){
        courses.put(course.getId(), course);
    }

    public Course findCourseById(String studentId){
        return courses.get(studentId);
    }
    
    public void saveOffering(CourseOffering offering){
        offerings.put(offering.getId(), offering);
    }

    public Optional<CourseOffering> findCoursOfferingById(String offeringId){
        return Optional.ofNullable(offerings.get(offeringId));
    }

    private CourseRepo(){
        courses = new HashMap<>();
        offerings = new HashMap<>();
    }
    
    public static CourseRepo getInstance(){
        if(INSTANCE == null){
            synchronized(StudentRepo.class){
                if(INSTANCE == null){
                    INSTANCE = new CourseRepo();
                }
            }
        }
        return INSTANCE;
    }
}
