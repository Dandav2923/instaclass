package com.clan.instaclass.instituteService.exceptions.teacher;

public class TeacherNotFoundException extends Exception {

    public TeacherNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
    public TeacherNotFoundException(String message){
        super(message);
    }

    public TeacherNotFoundException() {

    }
}
