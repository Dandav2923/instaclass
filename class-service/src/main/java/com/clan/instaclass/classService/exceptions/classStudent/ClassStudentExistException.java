package com.clan.instaclass.classService.exceptions.classStudent;

public class ClassStudentExistException extends Exception{
    public ClassStudentExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassStudentExistException(String message){
        super(message);
    }
}
