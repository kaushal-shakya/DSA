package lld1.concurrency2.AdderSubtractor.syncFixWithLock;

import java.util.concurrent.locks.Lock;

public class Subtracter implements Runnable {

    private Count c;
    private Lock l;

    public Subtracter(Count count, Lock l) {
        this.c = count;
        this.l = l;
    }

    @Override
    public void run() {
        for (int i=1; i <=10000; i++) {
            l.lock();
            c.x -= i;
            l.unlock();
        }
    }
}
