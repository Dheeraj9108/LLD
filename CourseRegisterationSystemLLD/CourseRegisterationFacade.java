package CourseRegisterationSystemLLD;

import CourseRegisterationSystemLLD.repository.CourseRepo;
import CourseRegisterationSystemLLD.repository.StudentRepo;

public class CourseRegisterationFacade {
    private CourseRegisterationService crs = new CourseRegisterationService();
    private CourseRepo courseRepo = CourseRepo.getInstance();
    private StudentRepo studentRepo = StudentRepo.getInstance();

    public void register(String studentId,String offeringId){
        studentRepo.findById(studentId).ifPresentOrElse(student ->{
            courseRepo.findCoursOfferingById(offeringId).ifPresentOrElse(offering->{
                crs.register(student, offering);
            }, ()->System.out.println("Course not found"));
        }, ()->{
            System.out.println("student not found");
        });
    }
    
    public void drop(String studentId, String offeringId){
        studentRepo.findById(studentId).ifPresentOrElse(student ->{
            courseRepo.findCoursOfferingById(offeringId).ifPresentOrElse(offering->{
                offering.drop(student);
            }, ()->System.out.println("Course not found"));
        }, ()->{
            System.out.println("student not found");
        });
    }
}
