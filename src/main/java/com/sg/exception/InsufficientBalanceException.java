package com.sg.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException (String str)
    {
        super(str);
    }
}
