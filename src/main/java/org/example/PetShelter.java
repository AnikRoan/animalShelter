package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PetShelter {
    private final AnimalSerialize animalSerialize = new AnimalSerialize();
    private List<Animal> animals = new ArrayList<>(animalSerialize.deSerialization());
    private final Scanner scanner = new Scanner(System.in);

    private void addPet() {
        System.out.println("fill in the details");

        System.out.print("name: ");
        String name = scanner.next();

        System.out.print("breed: ");
        String breed = scanner.next();

        System.out.print("age: ");
        double age = scanner.nextDouble();

        Animal animal = new Animal(name, breed, age);
        animals.add(animal);


    }

    private void showAll() {
        for (Animal animal : animals) {
            System.out.println("name " + animal.getName()
                    + " breed " + animal.getBreed()
                    + " age " + animal.getAge());
        }


    }

    private void saveAll() {
        animalSerialize.serialize(animals);
    }


    public void visual() {
        boolean exit = true;


        while (exit) {
            System.out.println("ACTIONS:\n 1 add pet\n 2 show all pets\n 3 remove pet\n 4 exit and add all changes");
            switch (scanner.next()) {
                case "1" -> addPet();
                case "2" -> showAll();
                case "3" -> removePet();
                case "4" -> {
                    saveAll();
                    exit = false;
                }
                default -> System.out.println("THERE IS NO SUCH COMMAND!!! TRY ONCE MORE\n");

            }
        }
    }


    private void removePet() {
        System.out.println(" pets name and numbers ");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println("name " + animals.get(i).getName() + " number: " + i);
        }
        System.out.println("enter number: ");
        int number = scanner.nextInt();
        animals.remove(animals.get(number));


    }

}
