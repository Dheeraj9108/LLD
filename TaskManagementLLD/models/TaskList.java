package TaskManagementLLD.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskList {
    private final String id;
    private String name;
    private List<Task> tasks;
    
    public TaskList(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        tasks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    
    public void addTask(Task task){
        tasks.add(task);
    }

    public void display(){
        for(Task task : tasks){
            task.display();
        }
    }
}   
