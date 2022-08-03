package com.clan.instaclass.classService.exceptions.homework;

public class HomeworkExistException extends Exception{
    public HomeworkExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public HomeworkExistException(String message){
        super(message);
    }
}
