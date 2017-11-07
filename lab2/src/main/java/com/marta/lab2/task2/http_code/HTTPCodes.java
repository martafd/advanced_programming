package com.marta.lab2.task2.http_code;

import lombok.Getter;

@Getter
public enum HTTPCodes {
    INFO (100, 199, "informational"),
    SUCCESS (200, 299, "success"),
    REDIRECTION (300, 399, "redirection"),
    CLIENT_ERROR (400, 499, "cilent error"),
    SERVER_ERROR (500, 599, "server error");

    private final int from;
    private final int to;
    private final String desc;

    HTTPCodes(int from, int to, String desc) {
        this.from = from;
        this.to = to;
        this.desc = desc;
    }
}
