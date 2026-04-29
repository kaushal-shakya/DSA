package lld1.concurrency2.AdderSubtractor;

public class Adder implements Runnable {

    private Count c;
    Adder(Count a) {
        c = a;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 100; i++) {
            c.x += i;
        }
    }
}
