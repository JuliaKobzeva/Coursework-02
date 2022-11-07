import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTime extends Repeatability{
    public LocalDate repeat(Integer integer, Task task){
        LocalDate date = task.getDate();
        return date;
    }

    @Override
    public String toString() {
        return "OneTime";
    }
}
