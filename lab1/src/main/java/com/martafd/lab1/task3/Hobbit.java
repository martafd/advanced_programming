package com.martafd.lab1.task3;

public class Hobbit extends Character {

    public Hobbit(){
        this.power = 0;
        this.hp = 3;
        System.out.println("Hobbit created");
    }


    public void toCry() {
        System.out.println("Hobbit: I have no power. I do not want to kill. Please do not kill me!.");
    }

    @Override
    public void kick(Character c) {
        toCry();
    }

    @Override
    public boolean isAlive() {
        if (this.hp <= 0) {
            System.out.println("Hobbit die");
            return false;
        }else {
            return true;
        }
    }
}
