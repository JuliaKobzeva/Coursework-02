import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    private Integer id = 0;
    private String headline;
    private String description;
    public enum Type{PERSONAL, WORK}

    private Type type;
    private LocalDate date;

    private Repeatability repeatability;

    public Task(String headline, String description,  LocalDate date, Type type, RepeatabilityType type2) {
        if(headline == null || headline.isBlank() || headline.isEmpty()){
            this.headline = "Задача";
        }else{
            this.headline = headline;
        }

        if(description == null || description.isBlank() || description.isEmpty()){
            this.description = "Описание";
        }else{
            this.description = description;
        }

        if(date == null){
            this.date = LocalDate.now();
        }else{
            this.date = date;
        }

        this.type = type;

        id++;

        switch (type2) {
            case ONETIME:
                this.repeatability = new OneTime();
                break;
            case DAILY:
                this.repeatability = new Daily();
                break;
            case WEEKLY:
                this.repeatability = new Weekly();
                break;
            case MONTHLY:
                this.repeatability = new Monthly();
                break;
            case ANNUAL:
                this.repeatability = new Annual();
                break;
        }
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return headline + " " + description + " " + date + " " + type + " " + repeatability;
    }
}
