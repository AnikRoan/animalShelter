package org.example.servise;


import org.example.model.Animal;
import org.example.model.Extensions;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PetShelter {
    private final Extensions extension = Extensions.JSON;
    private final String path = "src/main/resources/animal.";
    private final File file = new File(path + extension);
    private final AnimalSerialize animalSerialize = new AnimalSerialize();
    private List<Animal> animals = new ArrayList<>(animalSerialize.deSerialization(file));
    private final Scanner scanner = new Scanner(System.in);


    private void addPet() {
        System.out.println("FILL IN THR DETAILS");

        System.out.print("name: ");
        String name = scanner.next();

        System.out.print("breed: ");
        String breed = scanner.next();

        System.out.print("age: ");
        String age = scanner.next();

        Animal animal = new Animal(name, breed, age);
        animals.add(animal);


    }

    private boolean animalChecking(List<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("there are no animals in the shelter\n");
            return false;
        }
        return true;

    }

    private void showAll() {
        if (!animalChecking(animals)) {
            return;

        }
        System.out.println(animals);
    }

    private void saveAll() {
        animalSerialize.serialize(animals,file);
    }

    private void removePet() {
        boolean valid = true;
        if (!animalChecking(animals)) {
            return;
        }


        System.out.println(" pets name and numbers: ");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println("name: " + animals.get(i).getName() + " number: " + i);
        }

        while (valid) {
            System.out.print("enter the pet number, ");

            try {
                int number = scanner.nextInt();

                animals.remove(number);
                valid = false;


            } catch (Exception e) {
                System.out.println(" wrong number, try once more");
                scanner.nextLine();

            }

        }


    }


    public void userMenu() {
        boolean exit = true;


        while (exit) {
            System.out.println("ACTIONS:\n" +
                    "1 add pet\n" +
                    "2 show all pets\n" +
                    "3 remove pet\n" +
                    "4 exit and add all changes");

            switch (scanner.next()) {
                case "1" -> addPet();
                case "2" -> showAll();
                case "3" -> removePet();
                case "4" -> {
                    saveAll();
                    scanner.close();
                    exit = false;
                }
                default -> System.out.println("THERE IS NO SUCH COMMAND!!! TRY ONCE MORE\n");

            }
        }
    }


}
