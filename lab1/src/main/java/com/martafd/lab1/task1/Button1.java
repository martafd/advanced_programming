package com.martafd.lab1.task1;

public class Button1 implements ButtonInterface {

    @Override
    public void doSomething() {
        System.out.println("you click on Button1");
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
