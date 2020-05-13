package com.sparta.jp.exceptions;

public class SorterException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public SorterException(String message) {
        this.message = message;


    }
}
