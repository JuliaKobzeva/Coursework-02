import java.time.LocalDate;
import java.time.LocalDateTime;

public class Daily extends Task{

    public Daily(String headline, String description, LocalDate date, Type type) {
        super(headline, description, date, type);
    }

    public LocalDate repeat(LocalDate inputDate){
        LocalDate date = getDate();
        while(!date.isAfter(inputDate) ){
            date = date.plusDays(1);
        }
        return date;
    }
}
