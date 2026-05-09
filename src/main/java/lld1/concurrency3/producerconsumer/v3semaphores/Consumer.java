package lld1.concurrency3.producerconsumer.v3semaphores;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    private String id;

    public Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore, String id) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consumerSemaphore.acquire();
                store.removeItem(); // Act
                producerSemaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
