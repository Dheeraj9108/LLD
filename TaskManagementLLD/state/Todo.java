package TaskManagementLLD.state;

import TaskManagementLLD.enums.TaskStatus;
import TaskManagementLLD.models.Task;

public class Todo implements TaskState{

    @Override
    public TaskStatus getStatus() {
        return TaskStatus.TODO;
    }

    @Override
    public void startProgress(Task task) {
        task.setState(new InProgress());
    }

    @Override
    public void completeTask(Task task) {
    }

    @Override
    public void reOpen(Task task) {
    }
}
