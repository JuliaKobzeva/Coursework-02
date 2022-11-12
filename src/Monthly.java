import java.time.LocalDate;
import java.time.LocalDateTime;

public class Monthly extends Task{
    public Monthly(String headline, String description, LocalDate date, Type type) {
        super(headline, description, date, type);
    }

    public LocalDate repeat(LocalDate inputDate){
        LocalDate date = getDate();
        while(!date.isAfter(inputDate) ){
            date = date.plusMonths(1);
        }
        return date;
    }
}
