package org.example.custom;

import org.example.model.Animal;
import org.example.serialize.AnimalSerialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PetShelter {
    Animal animal;

    AnimalSerialize animalSerialize = new AnimalSerialize();
    private List<Animal> animals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private void addPet() {
        System.out.println("fill in the details");
        System.out.println("name");
        String name = scanner.nextLine();
        System.out.println("breed");
        String breed = scanner.nextLine();
        System.out.println("age");
        int age = scanner.nextInt();
        Animal animal = new Animal(name, breed, age);
        animals.add(animal);

    }

    private void showAll() {
        for (Animal a : animals) {
            System.out.println(a.getName() + a.getBreed() + a.getAge());
        }
    }


    public void visual() {

        boolean b = true;
        while (b) {

            switch (scanner.nextInt()) {
                case 1 -> addPet();
                case 2 -> showAll();
                case 3 -> removePet();
                case 4 -> {
                    animalSerialize.serialize(animals);
                    b = false;
                }

            }
        }
    }

    private void removePet() {
        System.out.println("enter the name og the pet you want to delete");
        String name = scanner.nextLine();
        if (animals.contains(name)) {
            animals.remove(name);
        }
    }
}

}
