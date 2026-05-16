package lld1.concurrency3.threadsafecounter.v2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounter {

    private int count = 0;
    private final Lock lock = new ReentrantLock();

    // Thread-safe increment
    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            // Always release the lock, even if an exception occurs
            lock.unlock();
        }
    }

    // Thread-safe read
    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeCounter counter = new ThreadSafeCounter();

        // Two threads increment the same shared counter
        Thread t1 = new Thread(() -> counter.increment());
        Thread t2 = new Thread(() -> counter.increment());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + counter.getCount()); // Output: Count: 2
    }
}