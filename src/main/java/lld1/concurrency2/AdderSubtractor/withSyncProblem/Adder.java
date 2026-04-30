package lld1.concurrency2.AdderSubtractor.withSyncProblem;

public class Adder implements Runnable {

    private Count c;
    Adder(Count a) {
        c = a;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++) {
            c.x += i;
        }
    }
}
