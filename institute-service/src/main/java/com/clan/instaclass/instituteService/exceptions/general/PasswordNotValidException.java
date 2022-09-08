package com.clan.instaclass.instituteService.exceptions.general;

public class PasswordNotValidException extends Exception {

    public PasswordNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public PasswordNotValidException(String message){
        super(message);
    }

    public PasswordNotValidException() {

    }
}
