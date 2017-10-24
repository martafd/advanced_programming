package com.martafd.lab1.task3;

public abstract class Character {
    int power = 0;
    int hp = 0;

    public abstract void kick(Character c);

    public abstract boolean isAlive();

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
