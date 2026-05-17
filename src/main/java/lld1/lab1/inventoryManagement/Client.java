package lld1.lab1.inventoryManagement;

import lld1.lab1.inventoryManagement.exception.DuplicateItemException;
import lld1.lab1.inventoryManagement.exception.InvalidQuantityException;

import java.util.*;


//https://docs.google.com/document/d/1c9ucepUt1oKl85LkoCVTgYNj96FpuG3jHxJavRafUyo/edit?tab=t.0#heading=h.vpc0ymjtodv7

public class Client {
    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Book("1", "C++", 453.22, 3, "Remma"));
        itemList.add(new Electronics("2", "Mouse", 43.22, 1, 4));


        System.out.println("Before Sorting -- ");
        itemList.stream().forEach(x -> System.out.println(x.getName() + " " + x.getPrice()));
        Collections.sort(itemList);
        System.out.println("After Sorting--");
        itemList.stream().forEach(x -> System.out.println(x.getName() + " " + x.getPrice()));

        Inventory<Electronics> inventory = new Inventory<>();
        try {
            inventory.add(new Electronics("5", "MacBook Air", 699.00, 1, 8));
            inventory.add(new Electronics("6", "AirPods", 199.00, 2, 8));
        } catch (DuplicateItemException | InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }

        Item t = inventory.get("5");
//        System.out.println(t);
        Item t1 = inventory.get("6");
//        System.out.println(t1);


        // Mixed inventory — any Item subtype allowed
        Inventory<Item> generalStore = new Inventory<>();
        try {
            generalStore.add(new Book("B3", "Head First Java", 399.0, 8, "Kathy Sierra"));
            generalStore.add(new Clothing("C1", "Levi's Jeans", 2499.0, 20, "M"));
            generalStore.add(new Electronics("E1", "AirPods", 9999.0, 15, 12));
            generalStore.add(new Electronics("E2", "MacBookAir", 23000.0, 12, 18));
            generalStore.add(new Book("B4" , "Java, The Complete Reference", 799.0, 3, "Herbert Schild"));

        } catch (InvalidQuantityException | DuplicateItemException e) {
            System.out.println(e.getMessage());
        }


        generalStore.get("E1");
        generalStore.get("C1");
        generalStore.get("E2");
        Deque<Item> queue = generalStore.recentlyViewed.getItems();
        System.out.println(queue);

        generalStore.get("E1");
        System.out.println(queue);

    }
}
