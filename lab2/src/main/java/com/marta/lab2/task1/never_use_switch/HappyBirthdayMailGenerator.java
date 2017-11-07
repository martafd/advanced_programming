package com.marta.lab2.task1.never_use_switch;

public class
HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "happy birthday " + mailInfo.getClient().getName();
    }
}
