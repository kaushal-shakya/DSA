package lld1.lab1.inventoryManagement;

import lld1.lab1.inventoryManagement.exception.DuplicateItemException;
import lld1.lab1.inventoryManagement.exception.InvalidQuantityException;

import java.util.*;

public class Inventory<T extends Item> {

    HashMap<String, T> map ;
    RecentlyViewed<Item> recentlyViewed;

    Inventory() {
        map = new HashMap<>();
        recentlyViewed = new RecentlyViewed<>(3);
    }

    void add(T item) throws DuplicateItemException, InvalidQuantityException {
        if(map.containsKey(item.getId())) {
            throw new DuplicateItemException("Adding duplicate item in inventory.");
        }
        if(item.getQuantity() < 0) {
            throw new InvalidQuantityException("Item should be greater than zero.");
        }

        map.put(item.getId(), item);
        System.out.println("New item with id: " + item.getId() + " added.");
    }

    void remove(T item) {
        String id = item.getId();
        map.remove(id);
    }

    T get(String id) {
        T item = map.get(id);
        recentlyViewed.view(item);
        return item;
    }

    List<Item> getAll() {
        return new ArrayList<>(map.values());
    }
}
