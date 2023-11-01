package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


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

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getAge() {
        return age;
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

    @Override
    public String toString() {
        return
                "name: " + name + '\'' +
                " breed: " + breed + '\'' +
                " age: " + age +"\n";
    }
}
