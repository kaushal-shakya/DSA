package lld1.generics.boundedtypes.v2;

import java.util.List;

public class Animal {
    public void eat() {
        System.out.println("Eating...");
    }

    //This only accepts List<Animal>. Can't pass List<Dog> or List<Cat>.
    public void feedAnimals(List<Animal> animals) {
        for (Animal a : animals){
            a.eat();
        }
    }

    // ? extends T (Upper Bounded Wildcard)
    // Animal is an upper bound --> All children are below
    public void feedAnyAnimals(List<? extends Animal> animals) {
        for(Animal a : animals)
            a.eat();
    }
}
