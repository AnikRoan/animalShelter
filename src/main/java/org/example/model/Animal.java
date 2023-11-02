package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


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


    public String toString() {
        return
                "name: " + name + '\'' +
                        " breed: " + breed + '\'' +
                        " age: " + age + "\n";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(breed, animal.breed) && Objects.equals(age, animal.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed, age);
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public String getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
