package com.marta.lab2.task3.mySpring;

public class App {

    public static void main( String[] args )
    {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
        System.out.println("iRobot.Version: " + iRobot.getVersion());
        System.out.println("iRobot.Name: " + iRobot.getName());

    }
}
