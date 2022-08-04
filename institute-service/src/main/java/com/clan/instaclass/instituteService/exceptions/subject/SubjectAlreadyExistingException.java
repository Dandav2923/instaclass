package com.clan.instaclass.instituteService.exceptions.subject;

public class SubjectAlreadyExistingException extends Exception {

    public SubjectAlreadyExistingException(String message, Throwable throwable){
        super(message, throwable);
    }
    public SubjectAlreadyExistingException(String message){
        super(message);
    }

    public SubjectAlreadyExistingException() {

    }
}
