package com.clan.instaclass.classService.exceptions.classStudent;

public class StudentAlreadyExistingException extends Exception{
    public StudentAlreadyExistingException(String message, Throwable throwable){
        super(message, throwable);
    }
    public StudentAlreadyExistingException(String message){
        super(message);
    }
}
