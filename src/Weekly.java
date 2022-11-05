import java.time.LocalDateTime;

public class Weekly extends Repeatability{
    public LocalDateTime repeat(Integer integer, Task task){
        LocalDateTime date = task.getDate();
        while(TaskService.taskList.containsKey(integer) ){
            date = task.getDate().plusDays(7);
        }
        return date;
    }

    @Override
    public String toString() {
        return "Weekly";
    }
}
