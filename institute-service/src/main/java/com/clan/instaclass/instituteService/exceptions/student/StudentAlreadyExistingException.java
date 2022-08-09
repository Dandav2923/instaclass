package com.clan.instaclass.instituteService.exceptions.student;

public class StudentAlreadyExistingException extends Exception {

    public StudentAlreadyExistingException(String message, Throwable throwable){
        super(message, throwable);
    }
    public StudentAlreadyExistingException(String message){
        super(message);
    }

    public StudentAlreadyExistingException() {

    }
}
