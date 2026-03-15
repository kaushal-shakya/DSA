package lld1.concurrency1;

public class HelloWordPrinter implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello World From new thread " + Thread.currentThread().getName()) ;
    }
}
