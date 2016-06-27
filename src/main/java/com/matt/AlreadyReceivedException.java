package com.matt;

public class AlreadyReceivedException extends Exception {
    public AlreadyReceivedException(String message) {
        super(message);
    }
}