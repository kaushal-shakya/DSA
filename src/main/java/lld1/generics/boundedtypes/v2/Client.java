package lld1.generics.boundedtypes.v2;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());

//        List<Animal> animalList = dogList;

        Animal animal = new Animal();
//        Uncomment below line to see the error
        animal.feedAnyAnimals(dogList); // Can't pass List<Dog> to List<Animal>
    }
}
