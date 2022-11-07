import java.time.LocalDate;
import java.time.LocalDateTime;

public class Annual extends Repeatability{
    public LocalDate repeat(Integer integer, Task task){
        LocalDate date = task.getDate();
        while(TaskService.taskList.containsKey(integer) ){
            date = task.getDate().plusDays(365);
        }
        return date;
    }

    @Override
    public String toString() {
        return "Annual";
    }
}
