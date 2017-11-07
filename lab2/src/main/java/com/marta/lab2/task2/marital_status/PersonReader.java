package com.marta.lab2.task2.marital_status;

import sun.misc.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {

    public static List<Person> createPerson() {
        List<Person> personsInFile = new ArrayList<>(4);
        personsInFile.add(new Person("Mstislav", MaritalStatus.SINGLE, 43));
        personsInFile.add(new Person("Yaroslav", MaritalStatus.DIVORCED, 23));
        personsInFile.add(new Person("Vasya", MaritalStatus.WIDOW, 35));
        personsInFile.add(new Person("Mstislav", MaritalStatus.WIDOW, 35));
        return personsInFile;
    }
}
