package lld1.concurrency2.AdderSubtractor.FixWithSyncroziedKey;

public class Subtracter implements Runnable {

    private Count c;

    public Subtracter(Count count) {
        this.c = count;
    }

    @Override
    public void run() {
        for (int i=1; i <=10000; i++) {
            synchronized (c) {
                c.x -= i;
            }
        }
    }
}
