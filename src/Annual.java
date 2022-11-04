import java.time.LocalDateTime;

public class Annual extends Repeatability{
    public LocalDateTime repeat(Integer integer, Task task){
        LocalDateTime date = task.getDate();
        while(TaskService.taskList.containsKey(integer) ){
            date = task.getDate().plusDays(365);
        }
        return date;
    }
}
