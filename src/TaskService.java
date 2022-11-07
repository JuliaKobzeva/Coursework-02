import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {
    public static Map<Integer, Task>taskList = new HashMap<>();

    public static void addTask(Integer integer, Task task){
        taskList.put(integer,task);
    }

    public static void removeTask(Integer integer){
        taskList.remove(integer);
    }

    public static List showTasks(LocalDate date){
        List<Task>list = new ArrayList<>();
        list.addAll(taskList.values());

        List<Task>list2 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
            if(date == list.get(i).getDate()){
                list2.add(list.get(i));
            }
        }
        return list2;
    }
}
