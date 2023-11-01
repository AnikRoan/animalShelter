package org.example.servise;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.model.Animal;
import org.example.model.Extensions;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;


public class AnimalSerialize {

    private final ObjectMapper objectMapper = new JsonMapper();
    private final Extensions extension = Extensions.JSON;
    private final String path = "src/main/resources/animal.";
    private final File file = new File(path + extension);


    public void serialize(List<Animal> animals) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            objectMapper.writeValue(file, animals);

        } catch (IOException e) {
            System.out.println("serialization error " + e.getMessage());

        }


    }

    public List<Animal> deSerialization() {
        if (file.exists()) {
            try (FileReader fileReader = new FileReader(file)) {
                return Arrays.asList(objectMapper.readValue(fileReader, Animal[].class));

            } catch (IOException e) {
                System.err.println("deSerialization error " + e.getMessage());
            }
        }

        return new ArrayList<>();
    }
}
