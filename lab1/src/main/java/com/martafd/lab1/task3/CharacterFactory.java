package com.martafd.lab1.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CharacterFactory {

    private List<Character> characters = null;
    private Random ran = new Random();

    public CharacterFactory() {
        this.characters = new ArrayList<>(4);
        this.characters.add(new Hobbit());
        this.characters.add(new Elf());
        this.characters.add(new King());
        this.characters.add(new Knight());
    }

    public Character createCharacter() {
        return this.characters.get(this.ran.nextInt(this.characters.size()));
    }
}
