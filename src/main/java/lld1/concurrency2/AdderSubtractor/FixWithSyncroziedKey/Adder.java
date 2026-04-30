package lld1.concurrency2.AdderSubtractor.FixWithSyncroziedKey;

public class Adder implements Runnable {

    private Count c;
    Adder(Count a) {
        c = a;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            synchronized (c) { // Lock on shared object here
                c.x += i;
            }
        }
    }
}
