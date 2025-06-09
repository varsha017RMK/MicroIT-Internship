import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    
    Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    void markComplete() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✓] " : "[ ] ") + description;
    }
}

 class ToDoListApp {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: addTask(); break;
                case 2: viewTasks(); break;
                case 3: markTaskComplete(); break;
                case 4: deleteTask(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void showMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Complete");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    static void addTask() {
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();
        tasks.add(new Task(desc));
        System.out.println("Task added.");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("\n--- Your Tasks ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    static void markTaskComplete() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to mark complete: ");
            int num = scanner.nextInt();
            if (num >= 1 && num <= tasks.size()) {
                tasks.get(num - 1).markComplete();
                System.out.println("Task marked as complete.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    static void deleteTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to delete: ");
            int num = scanner.nextInt();
            if (num >= 1 && num <= tasks.size()) {
                tasks.remove(num - 1);
                System.out.println("Task deleted.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
