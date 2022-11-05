import java.time.LocalDateTime;

public class Monthly extends Repeatability{
    public LocalDateTime repeat(Integer integer, Task task){
        LocalDateTime date = task.getDate();
        while(TaskService.taskList.containsKey(integer) ){
            date = task.getDate().plusMonths(1);
        }
        return date;
    }

    @Override
    public String toString() {
        return "Monthly";
    }
}
