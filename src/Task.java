import java.time.LocalDateTime;

public class Task {
    private Integer id = 0;
    private String headline;
    private String description;
    public enum Type{PERSONAL, WORK}

    private Type type;
    private LocalDateTime date;

    private Repeatability repeatability;

    public Task(String headline, String description,  Type type, RepeatabilityType type2) {
        this.headline = headline;
        this.description = description;
        this.date = LocalDateTime.now();
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

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return headline + " " + description + " " + date + " " + type + " " + repeatability;
    }
}
