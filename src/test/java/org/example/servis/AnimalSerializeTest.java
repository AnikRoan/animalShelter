package org.example.servis;

import org.example.model.Animal;
import org.example.servise.AnimalSerialize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AnimalSerializeTest {
    private final AnimalSerialize animalSerialize = new AnimalSerialize();
    private final List<Animal> animals = Arrays.asList(new Animal("COCO","bird","0,4")
            ,new Animal("FRIK","dog","1"));

    @Test
    public void serializeTest() {
        animalSerialize.serialize(animals);

    }
    @Test
    public void deSerializeTest(){
        List<Animal> animal = animalSerialize.deSerialization();
        Assertions.assertIterableEquals(animal,animals);
    }

}
