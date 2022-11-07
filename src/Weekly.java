import java.time.LocalDate;
import java.time.LocalDateTime;

public class Weekly extends Repeatability{
    public LocalDate repeat(Integer integer, Task task){
        LocalDate date = task.getDate();
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
