package com.marta.lab2.task3.mySpring;

public class Main {
    public static void main(String[] args) {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
        System.out.println(iRobot.getVersion());
    }
}
