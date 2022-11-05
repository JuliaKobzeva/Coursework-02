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
                System.out.print("Choose one point in the menu / Выберите пункт меню: ");
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
                    System.out.println("Choose one point in the menu / Выберите пункт меню из списка!");
                }
            }
        }
        System.out.println(TaskService.taskList);
        }

    private static void inputTask(Scanner scanner) {
        System.out.print("Put the name / Введите название задачи: ");
        String taskName = scanner.next ();
        System.out.print("Put the description / Введите описание задачи: ");
        String taskDescription = scanner.next ();
        printMenu2();
        System.out.print("Choose one point in the menu / Выберите пункт меню: ");

        if (scanner.hasNextInt()) {
        int menu2 = scanner.nextInt();
                switch (menu2) {
                    case 1:
                        Task.Type type = Task.Type.PERSONAL;
                        break;
                    case 2:
                        Task.Type type2 = Task.Type.WORK;
                        break;
                }
        } else {
        scanner.next();
        System.out.println("Choose one point in the menu / Выберите пункт меню из списка!");
        }

        printMenu3();
        System.out.print("Choose one point in the menu / Выберите пункт меню: ");
        if (scanner.hasNextInt()) {
            int menu3 = scanner.nextInt();
            switch (menu3) {
                case 1:
                    RepeatabilityType typeR = RepeatabilityType.ONETIME;
                    break;
                case 2:
                    RepeatabilityType typeR2 = RepeatabilityType.DAILY;
                    break;
                case 3:
                    RepeatabilityType typeR3 = RepeatabilityType.WEEKLY;
                    break;
                case 4:
                    RepeatabilityType typeR4 = RepeatabilityType.MONTHLY;
                    break;
                case 5:
                    RepeatabilityType typeR5 = RepeatabilityType.ANNUAL;
                    break;
            }
        } else {
            scanner.next();
            System.out.println("Choose one point in the menu / Выберите пункт меню из списка!");
        }
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Put id / Введите id задачи: ");
        Integer id = scanner.nextInt();
        TaskService.removeTask(id);
    }

    private static void showTasks(Scanner scanner) {
        System.out.print("Put the date (01 01 2022) / Введите дату(формат 01 01 2022): ");
        String date = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy", Locale.ROOT);
        LocalDateTime parsedDate = LocalDateTime.parse(date, formatter);
        TaskService.showTasks(parsedDate);
    }

    private static void printMenu() {
        System.out.println(
                """
                        1. Put the task / Добавить задачу
                        2. Remove the task / Удалить задачу
                        3. Show the tasks / Получить задачу на указанный день
                        0. Exit / Выход
                        """
        );
    }

    private static void printMenu2() {
        System.out.println(
                "1.PERSONAL 2. WORK"
        );
    }

    private static void printMenu3() {
        System.out.println(
                "1.ONETIME 2. DAILY 3. WEEKLY 4. MONTHLY 5. ANNUAL"
        );
    }
}