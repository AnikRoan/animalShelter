package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;




public class Animal {

    private String name;
    private String breed;
    private int age;




    public void setName(String name) {
        this.name = name;
    }

    @JsonCreator
    public Animal(@JsonProperty("name") String name,
                  @JsonProperty("breed") String breed,
                  @JsonProperty("age") int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
