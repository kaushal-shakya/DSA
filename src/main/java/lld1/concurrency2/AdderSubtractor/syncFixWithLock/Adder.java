package lld1.concurrency2.AdderSubtractor.syncFixWithLock;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {

    private Count c;
    private Lock l;

    Adder(Count a, Lock l) {
        c = a;
        this.l = l;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            l.lock();
            c.x += i;
            l.unlock();
        }
    }
}
