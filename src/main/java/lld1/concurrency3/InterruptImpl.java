package lld1.concurrency3;

public class InterruptImpl {




    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Working...");
            }
            System.out.println("Thread interrupted, exiting.");
        });

        t.start();

// Later...
        t.interrupt();   /// thread's interrupted flag becomes true

        /**
         * Interrupting a Blocked Thread.
         * If a thread is blocked in methods such as -
         *  - Thread.sleep(),
         *  - Objet.wait()
         *  - Thread.join()
         * an interrupt causes these methods to throw an InterruptedException.
         *
         * If another thread calls -> t.interrupt(), the blocked thread wakes up immediately and received the exception
         */

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            }catch (InterruptedException e) {
                System.out.println("Interrupted while sleeping");
            }
        });

        t1.interrupt();

    }
}
