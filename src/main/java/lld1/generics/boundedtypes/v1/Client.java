package lld1.generics.boundedtypes.v1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());

//        List<Animal> animalList = dogList;

        Animal animal = new Animal();
//        Uncomment below line to see the error
//        animal.feedAnimals(dogList); // Can't pass List<Dog> to List<Animal>. Problem here could be solved using Upper Bound Wildcards.
    }
}
