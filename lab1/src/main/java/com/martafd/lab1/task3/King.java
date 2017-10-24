package com.martafd.lab1.task3;

import java.util.Random;

public class King extends Character {
    private Random ran = new Random();

    public King(){
        this.power = this.ran.nextInt(5 + 15);;
        this.hp = this.ran.nextInt(5 + 15);;
        System.out.println("King created");
    }


    public King(boolean isFalse){
        this.power = this.ran.nextInt(15 - 10) + 10;;
        this.hp = this.ran.nextInt(15 - 10) + 10;;
    }

    @Override
    public void kick(Character c) {
        kickLogic(c);
        System.out.println("King kick " + c.getClass());
    }

    protected void kickLogic(Character c) {
        c.setHp(c.getHp() - this.ran.nextInt(this.power));
    }
    @Override
    public boolean isAlive() {
        if (this.hp <= 0) {
            System.out.println("King die");
            return false;
        }else {
            return true;
        }
    }
}
