package com.clan.instaclass.instituteService.exceptions.student;

public class StudentNotFoundException extends Exception {

    public StudentNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
    public StudentNotFoundException(String message){
        super(message);
    }

    public StudentNotFoundException() {

    }
}
