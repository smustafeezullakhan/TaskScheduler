import java.util.PriorityQueue;
import java.util.Scanner;

class Task implements Comparable<Task> {
    private String taskName;
    private int priority;
    private int executeTime;

    public Task(String taskName, int priority, int executeTime) {
        this.taskName = taskName;
        this.priority = priority;
        this.executeTime = executeTime;
    }

    @Override
    public int compareTo(Task other) {
        // Customize the comparison for priority
        return Integer.compare(this.priority, other.priority);
    }

    public void executeTask() {
        System.out.println("Executing task '" + taskName + "' with priority " + priority + "...");
        try {
            Thread.sleep(executeTime * 1000); // Sleep for executeTime seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task '" + taskName + "' completed.");
    }

    public String getTaskName() {
        return taskName;
    }

    public int getPriority() {
        return priority;
    }
}

