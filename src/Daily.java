import java.time.LocalDateTime;

public class Daily extends Repeatability{
    public LocalDateTime repeat(Integer integer, Task task){
        LocalDateTime date = task.getDate();
        while(TaskService.taskList.containsKey(integer) ){
            date = task.getDate().plusDays(1);
        }
        return date;
    }
}
