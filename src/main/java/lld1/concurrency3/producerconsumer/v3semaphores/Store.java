package lld1.concurrency3.producerconsumer.v3semaphores;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
//    private int maxSize;
    private Queue<Object> items;

    public Store() {
        this.items = new ConcurrentLinkedDeque<>();
    }

    public void addItem(Object item) {
        items.add(item);
        System.out.println("Producer added item. Current size: " + items.size());
    }

    public void removeItem() {
        Object item = items.remove(items.size() - 1);
        System.out.println("Consumer removed item. Current size: " + items.size());
    }
}
