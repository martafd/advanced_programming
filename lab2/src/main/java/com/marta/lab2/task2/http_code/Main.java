package com.marta.lab2.task2.http_code;

public class Main {
    public static void main(String args[]) {
        HttpService service = new HttpService();
        service.handle(123);
        service.handle(123234);
        service.handle(212);
        service.handle(432);
    }
}
