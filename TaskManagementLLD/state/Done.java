package TaskManagementLLD.state;

import TaskManagementLLD.enums.TaskStatus;
import TaskManagementLLD.models.Task;

public class Done implements TaskState{

    @Override
    public void startProgress(Task task) {
    }

    @Override
    public void completeTask(Task task) {
    }

    @Override
    public TaskStatus getStatus() {
        return TaskStatus.DONE;
    }

    @Override
    public void reOpen(Task task) {
        task.setState(new Todo());
    }

}
