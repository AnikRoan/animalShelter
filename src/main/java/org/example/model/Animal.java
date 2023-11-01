package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter

public class Animal {

    private String name;
    private String breed;
    private String age;


    @JsonCreator
    public Animal(@JsonProperty("name") String name,
                  @JsonProperty("breed") String breed,
                  @JsonProperty("age") String age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }













    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(breed, animal.breed) && Objects.equals(age, animal.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed, age);
    }
}
