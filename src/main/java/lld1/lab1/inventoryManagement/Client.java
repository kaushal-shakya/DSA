package lld1.lab1.inventoryManagement;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Book(1, "C++", 453.22, 3, "Remma"));
        itemList.add(new Electronics(2, "MOuse", 43.22, 1, 4));


        itemList.stream().forEach(x-> System.out.print(x.getName() + " "));


    }
}
