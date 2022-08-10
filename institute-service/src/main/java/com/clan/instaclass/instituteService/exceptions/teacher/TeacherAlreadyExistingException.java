package com.clan.instaclass.instituteService.exceptions.teacher;

public class TeacherAlreadyExistingException extends Exception {

    public TeacherAlreadyExistingException(String message, Throwable throwable){
        super(message, throwable);
    }
    public TeacherAlreadyExistingException(String message){
        super(message);
    }

    public TeacherAlreadyExistingException() {

    }
}
