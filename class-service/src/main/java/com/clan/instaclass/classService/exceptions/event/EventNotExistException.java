package com.clan.instaclass.classService.exceptions.event;

public class EventNotExistException extends Exception{
    public EventNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public EventNotExistException(String message){
        super(message);
    }
}
