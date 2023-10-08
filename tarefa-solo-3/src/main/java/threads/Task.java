package threads;

public class Task implements Runnable {
    private final String taskName;
    private volatile boolean completed;

    public Task(String taskName) {
        this.taskName = taskName;
        this.completed = false;
    }

    @Override
    public void run() {
        System.out.println("Executando a tarefa: " + taskName);
        // Adicione aqui o código específico da tarefa
        System.out.println("Tarefa " + taskName + " concluída.");
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }
}
