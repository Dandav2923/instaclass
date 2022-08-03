package com.clan.instaclass.classService.exceptions.classes;

public class ClassNotExistException extends Exception{
    public ClassNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassNotExistException(String message){
        super(message);
    }
}
