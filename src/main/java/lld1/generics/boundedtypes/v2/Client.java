package lld1.generics.boundedtypes.v2;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());
        List<Cat> catList = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        List<Mammal> mammals = new ArrayList<>();

//        List<Animal> animalList = dogList;

        Animal animal = new Animal();
//        ? extends Animal -->
        animal.feedAnyAnimals(dogList);
        animal.feedAnyAnimals(catList);
        animal.feedAnyAnimals(animals);
        animal.feedAnyAnimals(mammals);

        // ? super Dog -> some unknown type which is a dog or parent of Dog.
        animal.addDogs(dogList);
        animal.addDogs(mammals);
        animal.addDogs(animals);
        animal.addDogs(new ArrayList<Object>());
        // while reading --> load it into
        Animal a = animals.get(0); //

    }
}
