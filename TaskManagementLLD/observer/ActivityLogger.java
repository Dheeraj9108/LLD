package TaskManagementLLD.observer;

import TaskManagementLLD.models.Task;

public class ActivityLogger implements TaskObserver{

    @Override
    public void update(Task task, String change) {
        System.out.println("LOGGER: Task " + task.getId()+ "was updated. Change" + change);
    }
}
