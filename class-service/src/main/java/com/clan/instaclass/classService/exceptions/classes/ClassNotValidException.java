package com.clan.instaclass.classService.exceptions.classes;

public class ClassNotValidException extends Exception{
    public ClassNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassNotValidException(String message){
        super(message);
    }
}
