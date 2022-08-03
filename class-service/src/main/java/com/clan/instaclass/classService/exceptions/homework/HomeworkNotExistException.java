package com.clan.instaclass.classService.exceptions.homework;

public class HomeworkNotExistException extends Exception{
    public HomeworkNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public HomeworkNotExistException(String message){
        super(message);
    }
}
