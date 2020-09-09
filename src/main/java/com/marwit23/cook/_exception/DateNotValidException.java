package com.marwit23.cook._exception;

public class DateNotValidException extends RuntimeException {
    public DateNotValidException(){
        super("Input date is not valid.");
    }
}
