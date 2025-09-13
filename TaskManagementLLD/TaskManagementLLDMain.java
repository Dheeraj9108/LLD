package TaskManagementLLD;

import java.time.LocalDate;

import TaskManagementLLD.enums.TaskPriority;
import TaskManagementLLD.models.Task;
import TaskManagementLLD.models.TaskList;
import TaskManagementLLD.models.User;

public class TaskManagementLLDMain {
    public static void main(String[] args) {
        TaskManagementSystem system = TaskManagementSystem.getInstance();

        User alice = system.creatUser("Alice", "alice@gmail.com");
        User bob = system.creatUser("Alice", "alice@gmail.com");

        TaskList dataImport = system.createTaskList("Data Import");
        // TaskList artop = system.createTaskList("Artop");

        Task task1 = system.createTask("Task1", "description 1", LocalDate.now().plusDays(3), TaskPriority.LOW, alice, bob);

        dataImport.addTask(task1);

        dataImport.display();
        
        task1.startProgress();

        dataImport.display();

        task1.completeTask();

        dataImport.display();

    }
}
