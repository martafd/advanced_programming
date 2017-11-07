package com.marta.lab2.task3.mySpring;

public interface Config {
    <T> Class<T> getImpl(Class<T> ifc);
}
