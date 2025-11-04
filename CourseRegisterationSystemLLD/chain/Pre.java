package CourseRegisterationSystemLLD.chain;

import java.util.Set;

import CourseRegisterationSystemLLD.entities.Course;
import CourseRegisterationSystemLLD.entities.CourseOffering;
import CourseRegisterationSystemLLD.entities.Student;

public class Pre extends RegisterationRule{

    @Override
    public void handle(Student student, CourseOffering offering) {
        Set<Course> preCourse = offering.getCourse().getPre();
        if(!student.getCompletedCourses().containsAll(preCourse)){
            System.out.println("Course Not Completed");
            return;
        }
        handleNext(student, offering);
    }
    
}
