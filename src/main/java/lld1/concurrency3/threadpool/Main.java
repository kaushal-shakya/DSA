package lld1.concurrency3.threadpool;

public class Main {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(3);

        for (int i = 0; i < 10; i++) {
            myThreadPool.submit(new Task(i));
        }
    }
}
