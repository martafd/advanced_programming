package com.marta.lab2.task3.mySpring;

import factory.InjectRandomInt;

public class CleanerImpl implements Cleaner {
    @InjectRandomInt(min = 3, max = 7)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVvvvvvvvvvvvvvvvvv");
        }
    }
}
