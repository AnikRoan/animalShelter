package org.example.servis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.model.Animal;
import org.example.servise.AnimalSerialize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AnimalSerializeTest {
    private final ObjectMapper objectMapper = new JsonMapper();
    private final File testfile = new File("src/main/resources/animalTest.json");
    private final AnimalSerialize animalSerialize = new AnimalSerialize();
    private final List<Animal> animals = Arrays.asList(new Animal("COCO", "bird", "0,4")
            , new Animal("FRIK", "dog", "1"));

    @Test
    public void serializeTest() {
        try {
            if (!testfile.exists()) {
                testfile.createNewFile();
            }
            objectMapper.writeValue(testfile, animals);

        } catch (IOException e) {
            System.out.println("serialization error " + e.getMessage());

        }

        animalSerialize.serialize(animals,testfile);

    }



    @Test
    public void deSerializeTest(){
        List<Animal> animal = animalSerialize.deSerialization(testfile);
        if(animal.isEmpty()){
            Assertions.assertTrue(true);
        }else{
        Assertions.assertIterableEquals(animal, animals);

        }

    }

}
