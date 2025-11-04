package CourseRegisterationSystemLLD.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import CourseRegisterationSystemLLD.entities.Student;

public class StudentRepo {
    private final Map<String,Student> students;
    private static StudentRepo INSTANCE;
    
    public void save(Student student){
        students.put(student.getId(), student);
    }

    public Optional<Student> findById(String studentId){
        return Optional.ofNullable(students.get(studentId));
    }

    private StudentRepo(){
        students = new HashMap<>();
    }
    
    public static StudentRepo getInstance(){
        if(INSTANCE == null){
            synchronized(StudentRepo.class){
                if(INSTANCE == null){
                    INSTANCE = new StudentRepo();
                }
            }
        }
        return INSTANCE;
    }
}
