package CourseRegisterationSystemLLD.chain;

import CourseRegisterationSystemLLD.entities.CourseOffering;
import CourseRegisterationSystemLLD.entities.Student;

public class Conflict extends RegisterationRule{

    @Override
    public void handle(Student student,CourseOffering offering) {
        boolean overlaps = student.getRegisteredCourses().stream().anyMatch(studentCourse->studentCourse.getTimeSlot().overlaps(offering.getTimeSlot()));
        if(overlaps){
            System.out.println("Course Overlaped");
            return;
        }
        handleNext(student, offering);
    }
    
}
