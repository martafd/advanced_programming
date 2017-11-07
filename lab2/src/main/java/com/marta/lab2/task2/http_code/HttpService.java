package com.marta.lab2.task2.http_code;

public class HttpService {
    private HTTPCodes info = HTTPCodes.INFO;
    private HTTPCodes success = HTTPCodes.SUCCESS;
    private HTTPCodes redir = HTTPCodes.REDIRECTION;
    private HTTPCodes clie_err = HTTPCodes.CLIENT_ERROR;
    private HTTPCodes ser_err = HTTPCodes.SERVER_ERROR;

    public void handle(int code) {
        if (code >= this.info.getFrom() & code <= this.info.getTo()) {
            System.out.println("Info handled");
        } else if (code >= this.success.getFrom() & code <= this.success.getTo()) {
            System.out.println("success handled");
        } else if (code >= this.redir.getFrom() & code <= this.redir.getTo()) {
            System.out.println("redirect handled");
        } else if (code >= this.clie_err.getFrom() & code <= this.clie_err.getTo()) {
            System.out.println("client error handled");
        } else if (code >= this.ser_err.getFrom() & code <= this.ser_err.getTo()) {
            System.out.println("server error handled");
        } else {
            System.out.println("{'status': 'hacked'}");
        }
    }
}
