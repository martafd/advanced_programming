package com.martafd.lab1.task2;

import javax.swing.*;
import java.io.*;
import java.util.Random;


public class GuessGame {

    public void play(int max) {

        Random ran = new Random();
        int valueToGuess = ran.nextInt(max + 1);

        int value = Integer.parseInt(JOptionPane.showInputDialog("Guess value: "));

        int count = 1;
        while(value != valueToGuess) {

            if (value > valueToGuess) JOptionPane.showMessageDialog(null,"Your value is too big. Try smaller one!");
            if (value < valueToGuess) JOptionPane.showMessageDialog(null,"Your value is too small. Try bigger one!");
            value = Integer.parseInt(JOptionPane.showInputDialog("Try once more\nEnter value: "));
            count++;
        }

        printBestScore(max, count);

    }

    public void printBestScore(int max, int count) {
        double score = (double) max/count;
        System.out.println("Your score is " + score);

        saveScores(score);

    }

    public void saveScores(double score) {

        File file = new File("scores.txt");

        try {
            // check if file exists, if not -> create file
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(String.valueOf(score) + "\n");
            bw.close();
            System.out.println("Done");


        } catch (java.io.IOException e) {

        }

    }
}
