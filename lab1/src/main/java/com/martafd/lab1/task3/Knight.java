package com.martafd.lab1.task3;

import java.util.Random;

public class Knight extends King {

    private Random ran = new Random();

    public Knight(){
        super(false);
        this.power = this.ran.nextInt(12 - 10) + 10;
        this.hp = this.ran.nextInt(12 - 10) + 10;

        System.out.println("Knight created" + this.hp + " " + this.power);
    }


    @Override
    public void kick(Character c) {
        this.kickLogic(c);
        System.out.println("Knight kick " + c.getClass());
    }

    @Override
    public boolean isAlive() {
        if (this.hp <= 0) {
            System.out.println("Knight die");
            return false;
        }else {
            return true;
        }
    }
}
