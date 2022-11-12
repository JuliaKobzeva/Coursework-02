import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTime extends Task{
    public OneTime(String headline, String description, LocalDate date, Type type) {
        super(headline, description, date, type);
    }

    public LocalDate repeat(LocalDate inputDate){
        LocalDate date = getDate();
        return date;
    }
}
