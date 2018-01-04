package com.marta.lab2.task3.mySpring;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface InjectRandomInt {
    int min();
    int max();
}