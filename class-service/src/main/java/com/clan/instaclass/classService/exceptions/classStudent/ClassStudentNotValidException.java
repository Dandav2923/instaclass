package com.clan.instaclass.classService.exceptions.classStudent;

public class ClassStudentNotValidException extends Exception{
    public ClassStudentNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassStudentNotValidException(String message){
        super(message);
    }
}
