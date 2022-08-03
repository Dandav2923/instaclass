package com.clan.instaclass.classService.exceptions.classStudent;

public class ClassStudentNotExistException extends Exception{
    public ClassStudentNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassStudentNotExistException(String message){
        super(message);
    }
}
