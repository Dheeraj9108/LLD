package TaskManagementLLD.stratergy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import TaskManagementLLD.models.Task;

public class SortByPriority implements SortStratergy {
    @Override
    public List<Task> sort(List<Task> task) {
        return task.stream().sorted(Comparator.comparing(Task::getPriority)).collect(Collectors.toList());
    }
}
