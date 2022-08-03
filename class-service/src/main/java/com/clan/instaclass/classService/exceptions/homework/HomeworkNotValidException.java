package com.clan.instaclass.classService.exceptions.homework;

public class HomeworkNotValidException extends Exception{
    public HomeworkNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public HomeworkNotValidException(String message){
        super(message);
    }
}
