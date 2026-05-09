package lld1.concurrency3.producerconsumer.v3semaphores;

import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Semaphore producerSemaphore = new Semaphore(5);
        Semaphore consumerSemaphore = new Semaphore(0);

        // Hire 8 factory workers
        for (int i = 0; i < 8; i++) {
////            Producer producer = new Producer(store);
//            new Thread(producer).start();
        }

        // Open doors for 20 cutomers
        for (int i = 0; i < 20; i++) {
//            Consumer consumer = new Consumer(store);
//            new Thread(consumer).start();
        }
    }
}
