package CourseRegisterationSystemLLD.observer;

import CourseRegisterationSystemLLD.CourseRegisterationService;
import CourseRegisterationSystemLLD.entities.CourseOffering;

public class WaitObserver implements CourseObserver{
    private static WaitObserver INSATNCE;

    private CourseRegisterationService crs = new CourseRegisterationService();
    
    private WaitObserver(){}

    public static WaitObserver getInstance(){
        if(INSATNCE == null){
            synchronized(WaitObserver.class){
                if(INSATNCE == null){
                    INSATNCE = new WaitObserver();
                }
            }
        }
        return INSATNCE;
    }

    @Override
    public void onUpdate(CourseOffering offering) {
        System.out.printf("Notification %s course is now available \n",offering.getCourse().getTitle());
        offering.getNextFromWaitList().ifPresent(student->{
            System.out.printf("%s is now added to registedred list \n", student.getName());
            crs.register(student,offering);
        });
    }
    
}
