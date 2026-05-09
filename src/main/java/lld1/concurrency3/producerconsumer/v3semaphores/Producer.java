package lld1.concurrency3.producerconsumer.v3semaphores;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    private String id;

    public Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore, String id) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                producerSemaphore.acquire();
                store.addItem(new Object()); // Act
                consumerSemaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restores the interrupt flag
                break;
            }
        }
    }
}
