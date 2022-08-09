package com.sg.exception;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException (String str)
    {
        super(str);
    }
}
