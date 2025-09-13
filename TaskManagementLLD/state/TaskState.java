package TaskManagementLLD.state;

import TaskManagementLLD.enums.TaskStatus;
import TaskManagementLLD.models.Task;

public interface TaskState {
    public void startProgress(Task task);
    public void completeTask(Task task);
    public TaskStatus getStatus();
    public void reOpen(Task task);
}
