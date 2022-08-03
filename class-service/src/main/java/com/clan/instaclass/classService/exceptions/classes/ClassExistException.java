package com.clan.instaclass.classService.exceptions.classes;

public class ClassExistException extends Exception{
    public ClassExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassExistException(String message){
        super(message);
    }
}
