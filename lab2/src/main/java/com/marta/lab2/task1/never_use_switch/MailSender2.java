package com.marta.lab2.task1.never_use_switch;


import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MailSender2 {

    private Map<Integer, MailGenerator> map = new HashMap<>();

    public MailSender2() {
        Reflections scanner = new Reflections();
        Set<Class<? extends MailGenerator>> classes = scanner.getSubTypesOf(MailGenerator.class);
        for (Class<? extends MailGenerator> i : classes) {
            if (!Modifier.isAbstract(i.getModifiers())) {
                System.out.println(i);
            }
        }

    }

    public void sendMail(MailInfo mailInfo) {

        MailGenerator mailGenerator = map.get(mailInfo.getMailCode());
        if (mailGenerator == null) {
            throw new IllegalStateException(mailInfo.getMailCode() + " not supported yet");
        }
        String html = mailGenerator.generateHtml(mailInfo);
        send(html,mailInfo);


    }

    private void send(String html, MailInfo mailInfo) {
        System.out.println("sending to ... " + html);
    }


}
