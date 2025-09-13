package TaskManagementLLD;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import TaskManagementLLD.enums.TaskPriority;
import TaskManagementLLD.enums.TaskStatus;
import TaskManagementLLD.models.Task;
import TaskManagementLLD.models.TaskList;
import TaskManagementLLD.models.User;
import TaskManagementLLD.observer.ActivityLogger;
import TaskManagementLLD.stratergy.SortStratergy;

public class TaskManagementSystem {

    private static TaskManagementSystem INSTANCE;
    private Map<String, User> users;
    private Map<String, Task> tasks;
    private Map<String, TaskList> taskList;

    private TaskManagementSystem() {
        this.users = new HashMap<>();
        this.tasks = new HashMap<>();
        this.taskList = new HashMap<>();
    }

    public static TaskManagementSystem getInstance() {
        if (INSTANCE == null) {
            synchronized (TaskManagementSystem.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TaskManagementSystem();
                }
            }
        }
        return INSTANCE;
    }

    public User creatUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public Task createTask(String title, String description, LocalDate dueDate, TaskPriority priority,
            User createdBy, User assignee) {
        Task task = new Task.TaskBuilder(title)
                .setDescription(description)
                .setDueDate(dueDate)
                .setCreatedBy(createdBy)
                .setAssignee(assignee)
                .setTaskPriority(priority)
                .build();
        task.addObserver(new ActivityLogger());
        tasks.put(task.getId(), task);
        return task;
    }

    public TaskList createTaskList(String name) {
        TaskList list = new TaskList(name);
        taskList.put(list.getId(), list);
        return list;
    }

    public List<Task> listTaskByUser(String userId) {
        return tasks.values().stream()
                .filter(task -> task.getAssignee().getId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Task> listTaskByStatus(TaskStatus status) {
        return tasks.values().stream().filter(task -> task.getStatus() == status).collect(Collectors.toList());
    }

    public void deleteTaks(String taskId) {
        tasks.remove(taskId);
    }

    public List<Task> searchAndSort(String keyword, SortStratergy stratergy) {
        List<Task> matchingTasks = tasks.values().stream()
                .filter(task -> task.getDescription().contains(keyword) || task.getTitle().contains(keyword))
                .collect(Collectors.toList());
        return stratergy.sort(matchingTasks);
    }
}
