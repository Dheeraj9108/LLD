package CourseRegisterationSystemLLD.chain;

import CourseRegisterationSystemLLD.entities.CourseOffering;
import CourseRegisterationSystemLLD.entities.Student;

public abstract class RegisterationRule {
    private RegisterationRule next;
    
    public void setNext(RegisterationRule next){
        this.next = next;
    }

    public abstract void handle(Student student,CourseOffering offering);

    public void handleNext(Student student, CourseOffering offering){
        if(next != null) next.handle(student,offering);
    }
}
