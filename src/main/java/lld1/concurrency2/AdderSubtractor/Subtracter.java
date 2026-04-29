package lld1.concurrency2.AdderSubtractor;

public class Subtracter implements Runnable {

    private Count c;

    public Subtracter(Count count) {
        this.c = count;
    }

    @Override
    public void run() {
        for (int i=1; i <=100; i++) {
            c.x -= i;
        }
    }
}
