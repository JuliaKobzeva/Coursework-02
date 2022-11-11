import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Task implements Repetability{
    private Integer id = 0;
    private String headline;
    private String description;

    public enum Type{PERSONAL, WORK}

    private Type type;
    private LocalDate date;

    @Override
    public LocalDate repeat(LocalDate inputDate) {
        return null;
    }

    public Task(String headline, String description, LocalDate date, Type type) {
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
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return headline + " " + description + " " + date + " " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(headline, task.headline) && Objects.equals(description, task.description) && type == task.type && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, headline, description, type, date);
    }
}
