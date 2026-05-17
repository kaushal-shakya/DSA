package lld1.lab1.inventoryManagement;

import java.util.Objects;

public abstract class Item implements Comparable<Item>{
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Item(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int compareTo(Item o) {
        int i = (int) (this.price - o.price);
        return i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true; // both pointing to same address, it means same objects are equal
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item item = (Item) obj;
        return Objects.equals(id, ((Item) obj).getId());
    }

    @Override
    public String toString() {
        return "[ " + "\n" +
                    "\tid -> " + id + "\n" +
                    "\tname -> " + name + "\n" +
                    "\tprice -> " + price + "\n" +
                    "\tquantity -> " + quantity + "\n" +
                "]";
    }
}
