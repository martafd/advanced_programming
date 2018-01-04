package com.marta.lab2.task3.mySpring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> objectConfigurators = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {

        Reflections reflections = new Reflections("com.marta.lab2.task3.mySpring");

        Set<Class<? extends ObjectConfigurator>> objectConfiguratorSubTypes = reflections.getSubTypesOf(ObjectConfigurator.class);

        for (Class<? extends ObjectConfigurator> objectConfiguratorSubType : objectConfiguratorSubTypes) {
            if (!Modifier.isAbstract(objectConfiguratorSubType.getModifiers())) {
                objectConfigurators.add(objectConfiguratorSubType.newInstance());
            }
        }

    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type =  config.getImpl(type);
        }
        T o = type.newInstance();

        for (Iterator<ObjectConfigurator> iter = objectConfigurators.listIterator(); iter.hasNext(); ) {
            ObjectConfigurator objectConfigurator = iter.next();
            o = objectConfigurator.configureObject(o);
        }

        return o;
    }

    public List<ObjectConfigurator> getObjectConfigurator() {
        return objectConfigurators;
    }

    public void setObjectConfigurator(List<ObjectConfigurator> objectConfigurators) {
        this.objectConfigurators = objectConfigurators;
    }

    public void removeObjectConfigurator(ObjectConfigurator objectConfigurator) {
        for (Iterator<ObjectConfigurator> iter = objectConfigurators.listIterator(); iter.hasNext(); ) {
            ObjectConfigurator a = iter.next();
            if (a.equals(objectConfigurator)) {
                iter.remove();
            }
        }
    }

    public ObjectFactory addObjectConfigurator(ObjectConfigurator objectConfigurator) {
        objectConfigurators.add(objectConfigurator);
        return this;
    }

}