package com.clan.superAdmin.exception;

public class DataNotValidException extends Exception{
    public DataNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public DataNotValidException(String message){
        super(message);
    }
}
