package com.marta.lab2.task3.mySpring;

import lombok.SneakyThrows;
import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntConfigurator implements ObjectConfigurator{
    private Config config = new JavaConfig();
    private Random random = new Random();

    InjectRandomIntConfigurator() {
    }

    @SneakyThrows
    public <T> T configureObject(T o) {
        Class<T> type = (Class<T>) o.getClass();
        if (type.isInterface()) {
            type =  config.getImpl(type);
        }
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {

            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int randomIntValue = random.nextInt(max - min) + min;
                field.setAccessible(true);
                field.set(o,randomIntValue);

            }
        }

        return o;
    }
}