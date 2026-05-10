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

    public void feedAnimalsWithAddingAnimal(List<? extends Animal> animal) { //Parameter could be List<Dog>, List<Cat>, List<Mammal> and List<Animal>
//        animal.add(new Dog()); // Compile error, uncomment to check the error
        //Notes :
        // ? extends T --> read only
        // You can take OUT.
        // Can't put more thing IN because you might put the wrong type.
    }

    public void addDogs(List<? super Dog> list) {
        list.add(new Dog()); //safe to add dogs
        // ? super Dog --> some unknown type which is a dog or parent of Dog.
    }
}
