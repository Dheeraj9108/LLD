package TaskManagementLLD.observer;

import TaskManagementLLD.models.Task;

public interface TaskObserver {
    public void update(Task task, String change);
}
