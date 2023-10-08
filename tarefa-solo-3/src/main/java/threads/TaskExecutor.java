package threads;

import java.util.ArrayList;
import java.util.List;

public class TaskExecutor {
    private final List<Task> tasks;
    private final ThreadPool threadPool;

    public TaskExecutor(int poolSize) {
        tasks = new ArrayList<>();
        threadPool = new ThreadPool(poolSize);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void executeTasks() {
        for (Task task : tasks) {
            Thread thread = threadPool.getThread();
            if (thread != null) {
                thread.start();
            } else {
                System.out.println("Não há threads disponíveis para executar a tarefa: " + task.toString());
            }
        }
    }

    public void waitForCompletion() {
        boolean allCompleted = false;
        while (!allCompleted) {
            allCompleted = true;
            for (Task task : tasks) {
                if (!task.isCompleted()) {
                    allCompleted = false;
                    break;
                }
            }
        }
    }
}
