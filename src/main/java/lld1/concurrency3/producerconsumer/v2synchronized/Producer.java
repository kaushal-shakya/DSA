package lld1.concurrency3.producerconsumer.v2synchronized;

public class Producer implements Runnable {
    private Store store;

    Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (store) { // Lock
                if (store.getItems().size() < store.getMaxSize()) { // Check
                    // space available or not
                    store.addItem(new Object()); // Act
                }
            } // Unlock
        }
    }
}
