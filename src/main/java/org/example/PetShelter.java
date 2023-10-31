package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PetShelter {
   // public final AnimalSerialize animalSerialize;
    private final AnimalSerialize animalSerialize = new AnimalSerialize();
    private final List<Animal> animals = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    private void addPet() {
        System.out.println("fill in the details");
        System.out.println("name");
        String name = scanner.next();
        System.out.println("breed");
        String breed = scanner.next();
        System.out.println("age");
        int age = scanner.nextInt();

        Animal animal = new Animal(name, breed, age);
        animals.add(animal);
        //animalSerialize.serialize(animals);
        // visual();

    }

    private void showAll() {
        if (!animals.isEmpty()) {

            for (Animal a : animals) {
                System.out.println(" Name: " + a.getName() + " Breed: " + a.getBreed() + " Age: " + a.getAge());
            }
        } else {

            List<Animal> an = animalSerialize.deSerialize();
            for (Animal d : an) {
                System.out.println(d.getName() +" " + d.getBreed()+" " + d.getAge());
            }
        }
        // visual();
    }


    public void visual() {
        boolean b = true;


        while (b) {
            System.out.println("you want:\n 1 add pet\n 2 show all pet\n 3 remove pet\n 4 exit");
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
        System.out.println("enter the name or the pet you want to delete");
        String name = scanner.nextLine();
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equals(name)) animals.remove(i);
        }
        visual();
    }

}
