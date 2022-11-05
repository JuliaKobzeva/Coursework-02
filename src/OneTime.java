import java.time.LocalDateTime;

public class OneTime extends Repeatability{
    public LocalDateTime repeat(Integer integer, Task task){
        LocalDateTime date = task.getDate();
        return date;
    }

    @Override
    public String toString() {
        return "OneTime";
    }
}
