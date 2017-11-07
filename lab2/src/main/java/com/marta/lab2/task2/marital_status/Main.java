package com.marta.lab2.task2.marital_status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Person> personsInFile = PersonReader.createPerson();

        List<Person> newPersonList = new ArrayList<>(4);

        for (Person i: personsInFile) {
            if (newPersonList.contains(i)) {
                System.out.println("You again");
            } else {
                newPersonList.add(i);
                System.out.println(i);
            }
        }


//        MaritalStatus maritalStatus = MaritalStatus.findByDbCode(2);

//        System.out.println(maritalStatus.getRussianDesc());
    }
}
