package com.martafd.lab1.task3;

public class Elf extends Character {

    public Elf(){
        this.power = 10;
        this.hp = 10;
        System.out.println("Elf created");
    }


    @Override
    public void kick(Character c) {
        if (this.power > c.getPower()) {
            c.setHp(0);
            System.out.println("Elf kill " + c.getClass());

        } else {
            c.setPower(c.getPower() - 1);
            System.out.println(c.getClass() + " power decreased by Elf. The curr power is " + c.getPower());
        }

    }

    @Override
    public boolean isAlive() {
        if (this.hp <= 0) {
            System.out.println("Elf died");
            return false;
        }else {
            return true;
        }
    }

}
