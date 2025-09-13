package TaskManagementLLD.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import TaskManagementLLD.enums.TaskPriority;
import TaskManagementLLD.enums.TaskStatus;
import TaskManagementLLD.observer.TaskObserver;
import TaskManagementLLD.state.TaskState;
import TaskManagementLLD.state.Todo;

public class Task {
    private String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private User createdBy;
    private User assignee;
    private TaskPriority priority;
    private Set<Tag> tags;
    private List<Comment> comments;
    private List<ActivityLog> activityLog;
    private List<Task> subtasks;
    private TaskState state;
    private List<TaskObserver> observers;

    private Task(TaskBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.createdBy = builder.createdBy;
        this.assignee = builder.assignee;
        this.priority = builder.priority;
        this.tags = builder.tags;
        this.comments = new ArrayList<>();
        this.activityLog = new ArrayList<>();
        this.subtasks = new ArrayList<>();
        this.state = new Todo();
        this.observers = new ArrayList<>();
        addLog(new ActivityLog("Task Created"));
    }
    
    public void addObserver(TaskObserver observer){
        observers.add(observer);
    }

    public void startProgress(){
        TaskState todo = new Todo();
        todo.startProgress(this);
        state.startProgress(this);
    }

    public void completeTask(){
        state.completeTask(this);
    }

    public void reOpen(){
        state.reOpen(this);
    }

    public void setState(TaskState state){
        this.state = state;
        addLog(new ActivityLog("Status Updated " + state.getStatus()));
        notifyObservers("status");
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
        addLog(new ActivityLog("Comment Added"));
        notifyObservers("comment");
    }

    public void addSubtask(Task task){
        this.subtasks.add(task);
        addLog(new ActivityLog("Subtask created"));
        notifyObservers("subtask created");
    }

    public void updateTaskPriority (TaskPriority priority){
        this.priority = priority;
        addLog(new ActivityLog("Task Priority Updated"));
        notifyObservers("priority");
    }

    public void addLog(ActivityLog log){
        this.activityLog.add(log);
    }

    public void notifyObservers(String change){
        for(TaskObserver observer : observers){
            observer.update(this,change);
        }
    }

    public static class TaskBuilder {

        private String id;        
        private String title;
        private String description;
        private LocalDate dueDate;
        private User createdBy;
        private User assignee;
        private TaskPriority priority;
        private Set<Tag> tags;

        public TaskBuilder(String title){
            this.id = UUID.randomUUID().toString();
            this.title = title; 
        }

        public TaskBuilder setDescription(String description){
            this.description = description;
            return this;
        }

        public TaskBuilder setDueDate(LocalDate dueDate){
            this.dueDate = dueDate;
            return this;
        } 

        public TaskBuilder setCreatedBy(User createdBy){
            this.createdBy = createdBy;
            return this;
        }

        public TaskBuilder setAssignee(User assignee){
            this.assignee = assignee;
            return this;
        }

        public TaskBuilder setTaskBuilder(Set<Tag> tags){
            this.tags = tags;
            return this;
        }

        public TaskBuilder setTaskPriority(TaskPriority priority){
            this.priority = priority;
            return this;
        }

        public Task build(){
            return new Task(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public User getAssignee() {
        return assignee;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<ActivityLog> getActivityLog() {
        return activityLog;
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    public TaskState getState() {
        return state;
    }

    public List<TaskObserver> getObservers() {
        return observers;
    }

    public TaskStatus getStatus(){
        return state.getStatus();
    }

    public void display(){
        System.out.println("Title : " + getTitle() + " Priority:" + getPriority() + " Due Date: "+ getDueDate() + " Status : " + getStatus());
        if(!subtasks.isEmpty()){
            for(Task task : subtasks){
                task.display();
            }
        }
    }
}
