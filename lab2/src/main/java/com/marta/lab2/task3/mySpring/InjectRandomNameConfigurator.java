package com.marta.lab2.task3.mySpring;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomNameConfigurator implements ObjectConfigurator{
    private Config config = new JavaConfig();
    private Random random = new Random();

    Faker faker = new Faker();

    InjectRandomNameConfigurator() {
    }

    @SneakyThrows
    public <T> T configureObject(T o) {
        Class<T> type = (Class<T>) o.getClass();
        if (type.isInterface()) {
            type =  config.getImpl(type);
        }

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {

            InjectRandomName annotation = field.getAnnotation(InjectRandomName.class);
            if (annotation != null) {

                String randomNameValue = faker.name().firstName();
                field.setAccessible(true);
                field.set(o,randomNameValue);

            }
        }

        return o;
    }
}