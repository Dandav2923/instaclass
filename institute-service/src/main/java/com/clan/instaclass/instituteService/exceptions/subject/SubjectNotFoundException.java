package com.clan.instaclass.instituteService.exceptions.subject;

public class SubjectNotFoundException extends Exception {

    public SubjectNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
    public SubjectNotFoundException(String message){
        super(message);
    }

    public SubjectNotFoundException() {

    }
}
