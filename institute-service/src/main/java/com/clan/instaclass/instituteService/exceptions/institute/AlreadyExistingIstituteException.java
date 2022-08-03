package com.clan.instaclass.instituteService.exceptions.institute;

public class AlreadyExistingIstituteException extends Exception {

    public AlreadyExistingIstituteException(String message, Throwable throwable){
        super(message, throwable);
    }
    public AlreadyExistingIstituteException(String message){
        super(message);
    }

    public AlreadyExistingIstituteException() {

    }
}
