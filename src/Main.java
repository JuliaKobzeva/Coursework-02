import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Task one = new Task("первая заметка","описание",Task.Type.WORK, RepeatabilityType.DAILY);
        //TaskService.addTask(1,one);
        //System.out.println(one.getId());
        //System.out.println(one.getDate());
        //System.out.println(TaskService.taskList);
       //System.out.println(TaskService.showTasks(one.getDate()));

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            removeTask(scanner);
                            break;
                        case 3:
                            showTasks(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
        }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next ();
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Введите id задачи: ");
        Integer id = scanner.nextInt();
        TaskService.removeTask(id);
    }

    private static void showTasks(Scanner scanner) {
        System.out.print("Введите дату(формат 01 01 2022): ");
        String date = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy", Locale.ROOT);
        LocalDateTime parsedDate = LocalDateTime.parse(date, formatter);
        TaskService.showTasks(parsedDate);
    }

    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );
    }
}