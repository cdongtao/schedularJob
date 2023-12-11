package org.example.test;

import lombok.Data;

@Data
public class Person {
    String id;
    String name;
    String age;
    String gender;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
