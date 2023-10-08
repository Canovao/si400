package threads;

import java.util.LinkedList;

public class ThreadPool {
    private final LinkedList<Thread> availableThreads;

    public ThreadPool(int poolSize) {
        availableThreads = new LinkedList<>();
        for (int i = 0; i < poolSize; i++) {
            Thread thread = new Thread();
            availableThreads.add(thread);
        }
    }

    public synchronized Thread getThread() {
        if (availableThreads.isEmpty()) {
            return null;
        }
        return availableThreads.removeFirst();
    }

    public synchronized void releaseThread(Thread thread) {
        availableThreads.add(thread);
    }
}

