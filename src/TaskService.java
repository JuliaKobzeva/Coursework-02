import java.time.LocalDate;
import java.util.*;

public class TaskService {
    public static Map<Integer, Task>taskList = new HashMap<>();

    public static void addTask(Integer integer, Task task){
        taskList.put(integer,task);
    }

    public static void removeTask(Integer integer){
        taskList.remove(integer);
    }

//    public static List showTasks(LocalDate date){
//        List<Task>list = new ArrayList<>();
//        list.addAll(taskList.values());
//
//        List<Task>list2 = new ArrayList<>();
//
//        for (int i = 0; i < list.size(); i++) {
//            if(date.equals(list.get(i).getDate())){
//                list2.add(list.get(i));
//            }
//        }
//        return list2;
//    }

    public static Collection<Task>showTasks(LocalDate date){
        List<Task> resultList = new ArrayList<>();
        for (Map.Entry<Integer,Task> integerTaskEntry : taskList.entrySet()){
            var task = integerTaskEntry.getValue();
            if(date.equals(task.getDate())){
                resultList.add(task);
            }
        }
        return resultList;
    }
}
