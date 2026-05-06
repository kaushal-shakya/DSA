package lld1.concurrency3.producerconsumer.v2synchronized;

public class Consumer implements Runnable{
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (store) { // Lock
                if (store.getItems().size() > 0) { // Check
                    store.removeItem(); // Act
                }
            } // Unlock
        }
    }
}
