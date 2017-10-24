package com.martafd.lab1.task3;

import java.util.Random;

public class GameManager {

    private Random ran = new Random();

    public void fight(Character c1, Character c2) {

        while (c1.isAlive() && c2.isAlive()) {
            if (this.ran.nextBoolean()) {
                c1.kick(c2);
            } else {
                c2.kick(c1);
            }
        }

    }
}
