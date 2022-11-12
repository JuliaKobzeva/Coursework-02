import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Task one = new Task("первая заметка","описание",null, Task.Type.WORK);
//        Task two = new Task("вторая заметка","описание",one.getDate(), Task.Type.WORK);
//        TaskService.addTask(1,one);
//        TaskService.addTask(2,two);
//        System.out.println(one.getId());
//        System.out.println(one.getDate());
//        System.out.println(TaskService.taskList);
//        System.out.println(TaskService.showTasks(one.getDate()));

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
        System.out.print("Put the date (01.01.2022) / Введите дату (формат 01.01.2022): ");
        String date = scanner.next();
        LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        printMenu_TypeOfTask();
        System.out.print("Choose one point in the menu / Выберите пункт меню: ");


        Task.Type type = Task.Type.PERSONAL;
        if (scanner.hasNextInt()) {
            int menu2 = scanner.nextInt();
            switch (menu2) {
                case 1:
                    type = Task.Type.PERSONAL;
                    break;
                case 2:
                    type = Task.Type.WORK;
                    break;
            }
        } else {
            scanner.next();
            System.out.println("Choose one point in the menu / Выберите пункт меню из списка!");
        }

        printMenu_RepeatabilityType();
        System.out.print("Choose one point in the menu / Выберите пункт меню: ");

        if (scanner.hasNextInt()) {
            int menu3 = scanner.nextInt();
            switch (menu3) {
                case 1:
                    OneTime task1 = new OneTime(taskName,taskDescription, taskDate, type);
                    TaskService.addTask(task1.getId(),task1);
                    break;
                case 2:
                    Daily task2 = new Daily(taskName,taskDescription, taskDate, type);
                    TaskService.addTask(task2.getId(),task2);
                    break;
                case 3:
                    Weekly task3 = new Weekly(taskName,taskDescription, taskDate, type);
                    TaskService.addTask(task3.getId(),task3);
                    break;
                case 4:
                    Monthly task4 = new Monthly(taskName,taskDescription, taskDate, type);
                    TaskService.addTask(task4.getId(),task4);
                    break;
                case 5:
                    Annual task5 = new Annual(taskName,taskDescription, taskDate, type);
                    TaskService.addTask(task5.getId(),task5);
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
        System.out.print("Put the date (01.01.2022) / Введите дату(формат 01.01.2022): ");
        String date = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        System.out.println(TaskService.showTasks(parsedDate));
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

    private static void printMenu_TypeOfTask() {
        System.out.println(
                "1.PERSONAL 2. WORK"
        );
    }

    private static void printMenu_RepeatabilityType() {
        System.out.println(
                "1.ONETIME 2. DAILY 3. WEEKLY 4. MONTHLY 5. ANNUAL"
        );
    }
}