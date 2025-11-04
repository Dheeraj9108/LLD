package CourseRegisterationSystemLLD;

import java.time.DayOfWeek;
import java.time.LocalTime;

import CourseRegisterationSystemLLD.entities.Course;
import CourseRegisterationSystemLLD.entities.CourseOffering;
import CourseRegisterationSystemLLD.entities.Professor;
import CourseRegisterationSystemLLD.entities.Student;
import CourseRegisterationSystemLLD.entities.TimeSlot;
import CourseRegisterationSystemLLD.observer.WaitObserver;
import CourseRegisterationSystemLLD.repository.CourseRepo;
import CourseRegisterationSystemLLD.repository.StudentRepo;

public class CourseRegisterationSystemLLDMain {
    public static void main(String[] args) {
        // 1. Setup the system
        CourseRegisterationFacade system = new CourseRegisterationFacade();
        StudentRepo studentRepo = StudentRepo.getInstance();
        CourseRepo courseRepo = CourseRepo.getInstance();
        WaitObserver waitlistManager = WaitObserver.getInstance();

        // 2. Setup courses and professors
        Course cs101 = new Course("CS101", "Intro to Programming");
        Course cs201 = new Course("CS201", "Data Structures");
        cs201.addPrerequisite(cs101);
        courseRepo.saveCourse(cs101);
        courseRepo.saveCourse(cs201);

        Professor profA = new Professor("Dr. Smith");

        // 3. Setup course offerings using the Builder
        CourseOffering cs101Offering = new CourseOffering.Builder()
                .setCourse(cs101).setProfessor(profA)
                .setTimeSlot(new TimeSlot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 30)))
                .setCapacity(1).build();

        CourseOffering cs201Offering = new CourseOffering.Builder()
                .setCourse(cs201)
                .setProfessor(profA)
                .setTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, LocalTime.of(14, 0), LocalTime.of(15, 30)))
                .setCapacity(2).build();

        // Register the WaitlistManager as an observer for the course offering
        cs101Offering.addObserver(waitlistManager);

        courseRepo.saveOffering(cs101Offering);
        courseRepo.saveOffering(cs201Offering);

        // 4. Setup students
        Student alice = new Student("S1", "Alice");
        Student bob = new Student("S2", "Bob");
        Student charlie = new Student("S3", "Charlie");
        alice.addCompletedCourse(cs101); // Alice has the prerequisite for CS201
        studentRepo.save(alice);
        studentRepo.save(bob);
        studentRepo.save(charlie);

        // 5. Run Registration Scenarios
        System.out.println("----------- SCENARIO 1: Successful Registration -----------");
        system.register(alice.getId(), cs201Offering.getId());

        System.out.println("\n----------- SCENARIO 2: Prerequisite Failure -----------");
        system.register(bob.getId(), cs201Offering.getId());

        System.out.println("\n----------- SCENARIO 3: Course Capacity and Waitlist -----------");
        system.register(bob.getId(), cs101Offering.getId()); // Bob gets the last spot
        system.register(charlie.getId(), cs101Offering.getId()); // Charlie gets waitlisted

        System.out.println(
                "\n----------- SCENARIO 4: Dropping a course and Observer pattern triggering waitlist promotion -----------");
        system.drop(bob.getId(), cs101Offering.getId());
    }
}
