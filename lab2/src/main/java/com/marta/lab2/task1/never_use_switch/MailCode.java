package com.marta.lab2.task1.never_use_switch;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface MailCode {
    int value();
}
