package lld1.lab1.inventoryManagement;

import java.util.Deque;
import java.util.LinkedList;

public class RecentlyViewed<T> {
    private int MAX_SIZE;
    private Deque<T> items;

    public RecentlyViewed(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        items = new LinkedList<>();
    }

    public Deque<T> getItems() {
        return items;
    }

    public void setItems(Deque<T> items) {
        this.items = items;
    }

    /**
     * Adds an item as most recently viewed.
     * - If already present, remove old occurrence.
     * - Add to the front.
     * - If size exceeds MAX_SIZE, remove from the back.
     */
    public void view(T item) {
        // Remove existing occurrence if present
        items.remove(item);

        // Add to front (most recent)
        items.addFirst(item);

        // Remove old if capacity exceeded
        if (items.size() > MAX_SIZE) {
            items.removeLast();
        }
    }
}
