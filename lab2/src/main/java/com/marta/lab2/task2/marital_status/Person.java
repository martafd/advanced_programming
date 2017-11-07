package com.marta.lab2.task2.marital_status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Person {
    private String name;
    private MaritalStatus maritalStatus;
    private int age;

    @Override
    public String toString() {
        return this.name + " " + "age: " + this.age + ", " + this.maritalStatus.toString();
//        return russianDesc.toUpperCase();
    }

    @Override
    public boolean equals(Object o){
//        System.out.println("equals");
//        System.out.println(this.name.equals(((Person)(o)).getName()));
        return this.name.equals(((Person)(o)).getName());
    }
}
