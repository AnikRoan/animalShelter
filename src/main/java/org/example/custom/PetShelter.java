package org.example.custom;

import org.example.model.Animal;
import org.example.serialize.AnimalSerialize;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class PetShelter {


   public AnimalSerialize animalSerialize = new AnimalSerialize();
    private final List<Animal> animals = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

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
        System.out.println("you want 1 add pet 2 show all pet 3 remove pet 4 exit");

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
        System.out.println("enter the name or the pet you want to delete");
        String name = scanner.nextLine();
        for(int i=0;i<animals.size();i++){
            if(animals.get(i).getName().equals(name)) animals.remove(i);
    }
}

}
