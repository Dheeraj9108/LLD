package CourseRegisterationSystemLLD.chain;

import CourseRegisterationSystemLLD.entities.CourseOffering;
import CourseRegisterationSystemLLD.entities.Student;

public class Capacity extends RegisterationRule{

    @Override
    public void handle(Student student,CourseOffering offering) {
        if(offering.isFull()){
            offering.getWaiting().add(student);
            System.out.printf("%s Student added for waiting list \n", student.getName());
        } else {
            offering.getRegistered().add(student);
            System.out.printf("%s Student registered \n", student.getName());
        }
        handleNext(student, offering);
    }
    
}
