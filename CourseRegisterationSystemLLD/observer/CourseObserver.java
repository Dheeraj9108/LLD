package CourseRegisterationSystemLLD.observer;

import CourseRegisterationSystemLLD.entities.CourseOffering;

public interface CourseObserver {

    public void onUpdate(CourseOffering offering);
}