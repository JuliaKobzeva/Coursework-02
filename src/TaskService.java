import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {
    public static Map<Integer, Task>taskList = new HashMap<>();

    public void addTask(Integer integer, Task task){
        taskList.put(integer,task);
    }

    public void removeTask(Integer integer, Task task){
        taskList.remove(integer,task);
    }

    public List showTasks(LocalDateTime date){
        List<Task>list = new ArrayList<>();
        return list;
    }
}
