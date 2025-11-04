package CourseRegisterationSystemLLD;

import CourseRegisterationSystemLLD.chain.Capacity;
import CourseRegisterationSystemLLD.chain.Conflict;
import CourseRegisterationSystemLLD.chain.Pre;
import CourseRegisterationSystemLLD.chain.RegisterationRule;
import CourseRegisterationSystemLLD.entities.CourseOffering;
import CourseRegisterationSystemLLD.entities.Student;

public class CourseRegisterationService {
    private final RegisterationRule rule;

    public CourseRegisterationService(){
        Capacity capacityRule = new Capacity();
        Conflict conflictRule = new Conflict();
        conflictRule.setNext(capacityRule);
        Pre preRule = new Pre();
        preRule.setNext(conflictRule);
        rule = preRule;
    }

    public void register(Student student, CourseOffering offering){
        rule.handle(student, offering);
    }
}
