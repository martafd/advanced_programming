package com.martafd.lab1;

import com.martafd.lab1.task1.Button1;
import com.martafd.lab1.task1.Button2;
import com.martafd.lab1.task1.ButtonInterface;
import com.martafd.lab1.task2.GuessGame;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;


public class App 
{
    public static void main( String[] args )
    {
        task2();

//        System.out.println( "Hello World!" );
    }

    public static void task1() {
        // avoid using switch-case
        Map<String,ButtonInterface> map = new HashMap<String,ButtonInterface>();
        map.put("But1", new Button1());
        map.put("But2", new Button2());

        String event = "But1";

        map.get(event).doSomething();   // get object(which implements ButtonInterface)
                                        // from map and call method

        // the same realisation, but using switch-case
        switch (event){
            case "But1":
                System.out.println("you click on Button1 - switch");
                break;
            case "But2":
                System.out.println("you click on Button2 - switch");
                break;
        }
    }

    public static void task2() {

        int maxValue = Integer.parseInt(JOptionPane.showInputDialog("Enter max value: "));

        GuessGame game = new GuessGame();
        game.play(maxValue);

    }
}
