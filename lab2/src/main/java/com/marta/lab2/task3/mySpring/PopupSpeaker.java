package com.marta.lab2.task3.mySpring;

import javax.swing.*;

public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}