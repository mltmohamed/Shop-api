package com.mohcode.dream.shops.exceptions;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException (String message) {
        super(message);
    }
}
