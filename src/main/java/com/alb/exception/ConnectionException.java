package com.alb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.UnknownHostException;

@ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
public class ConnectionException extends UnknownHostException {

    private static final long serialVersionUID = 1L;

    public ConnectionException(String msg) {
        super(msg);
    }
}
