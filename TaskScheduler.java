import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskScheduler {
    private PriorityQueue<Task> taskQueue;
    private Scanner scanner;

    public TaskScheduler() {
        taskQueue = new PriorityQueue<>();
        scanner = new Scanner(System.in);
    }

    public void addTaskFromUserInput() {
        System.out.println("Enter task name: ");
        String taskName = scanner.nextLine();

        System.out.println("Enter task priority (integer): ");
        int priority = scanner.nextInt();

        System.out.println("Enter task execution time (in seconds): ");
        int executeTime = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Task task = new Task(taskName, priority, executeTime);
        taskQueue.add(task);
    }

    public void scheduleTasks() {
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            task.executeTask();
        }
    }

    public void viewTaskQueue() {
        System.out.println("Task Queue:");
        for (Task task : taskQueue) {
            System.out.println("Task: " + task.getTaskName() + ", Priority: " + task.getPriority());
        }
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        Scanner scanner = new Scanner(System.in);

        // Take input and add tasks
        System.out.println("Enter the number of tasks: ");
        int numTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numTasks; i++) {
            System.out.println("Task " + (i + 1) + ":");
            taskScheduler.addTaskFromUserInput();
        }

        // View the task queue
        taskScheduler.viewTaskQueue();

        // Start scheduling tasks
        taskScheduler.scheduleTasks();

        System.out.println("All tasks completed.");
        scanner.close();
    }
}
