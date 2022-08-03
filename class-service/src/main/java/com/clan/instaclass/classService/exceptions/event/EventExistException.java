package com.clan.instaclass.classService.exceptions.event;

public class EventExistException extends Exception{
    public EventExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public EventExistException(String message){
        super(message);
    }
}
