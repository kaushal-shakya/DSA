package lld1.concurrency3.threadsafecounter.v1;


public class ThreadSafeCounter implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        count++;
    }

    public static void main(String[] args) {
        //Single object to work on shared count variable
        ThreadSafeCounter obj1 = new ThreadSafeCounter();

        //t1 thread increments obj1.count
        Thread t1 = new Thread(obj1);
        t1.start();

        //t2 thread increments obj1.count
        Thread t2 = new Thread(obj1);
        t2.start();

        //print
        System.out.println("count " + obj1.count);
    }


}
