package lld1.concurrency3.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThreadPool {
    private int poolSize;
    private Worker[] workers;
    private BlockingQueue<Task> taskQueue;

    public MyThreadPool(int poolSize) {
        this.poolSize = poolSize;
        this.workers = new Worker[poolSize];
        this.taskQueue = new LinkedBlockingDeque<>();

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Worker("Worker - " + i, taskQueue);
            workers[i].start();
        }
    }

    public void submit(Task task) {
        taskQueue.offer(task);
    }
}
