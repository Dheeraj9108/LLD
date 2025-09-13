package TaskManagementLLD.state;

import TaskManagementLLD.enums.TaskStatus;
import TaskManagementLLD.models.Task;

public class InProgress implements TaskState{

    @Override
    public void startProgress(Task task) {
    }

    @Override
    public void completeTask(Task task) {
        task.setState(new Done());
    }

    @Override
    public TaskStatus getStatus() {
        return TaskStatus.INPROGRESS;
    }

    @Override
    public void reOpen(Task task) {
    }
    
}
