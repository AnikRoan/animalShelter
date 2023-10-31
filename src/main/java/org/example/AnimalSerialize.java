package org.example;


import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public  class AnimalSerialize {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Extensions exception = Extensions.JSON;
    private final String path = "src/main/resources/animal.";
    private final    File file = new File(path + exception);


    public void serialize(List<Animal> animals) {


        try {
            if (file.exists()) {
        List<Animal> l = objectMapper.readValue(file, new TypeReference<>() {
                });
                animals.addAll(l);
                objectMapper.writeValue(file, animals);


            }
            objectMapper.writeValue(file, animals);
        } catch (IOException e) {
            System.out.println("Ошибка при сереализации");
        }


    }

    public List<Animal> deSerialize() {
        List<Animal> animals = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file)) {
            animals = objectMapper.readValue(fileReader, new TypeReference<>() {
            });
        } catch (IOException e) {
            System.err.println("Ошибка при десериализации: " + e.getMessage());
        }

        return animals;
    }
}
