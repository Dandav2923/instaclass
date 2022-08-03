package com.clan.instaclass.classService.exceptions.event;

public class EventNotValidException extends Exception{
    public EventNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public EventNotValidException(String message){
        super(message);
    }
}
