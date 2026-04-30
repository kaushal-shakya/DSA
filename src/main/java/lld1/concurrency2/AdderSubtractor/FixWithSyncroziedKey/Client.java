package lld1.concurrency2.AdderSubtractor.FixWithSyncroziedKey;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Adder adder = new Adder(count);
        Subtracter subtracter = new Subtracter(count);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtracter);

        t1.start();
        t2.start();

        t1.join();
        System.out.println(t1.getState());
        System.out.println(t2.getState());

        t2.join();
        System.out.println(t2.getState());

        System.out.println("Final value : " + count.x);
    }
}
