package com.marta.lab2.task1.never_use_switch;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

//@Slf4j
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        MailSender2 mailSender = new MailSender2();
        DataFactory dataFactory = new DataFactory();
        System.exit(0);

        while (true) {
            MailInfo mailInfo = null;
            mailInfo = new MailInfo(dataFactory.getNumberBetween(1, 4));
            mailInfo.setClient(new Client(dataFactory.getName(), dataFactory.getNumberBetween(10, 100)));
            try {
                mailSender.sendMail(mailInfo);
            } catch (Exception e) {

                System.err.println(e.getMessage());
                e.printStackTrace();
//                System.err.println("this is not so importannt message");
//                System.err.println("totally not important only for the developers");
            }
            Thread.sleep(1000);
        }
    }
}
