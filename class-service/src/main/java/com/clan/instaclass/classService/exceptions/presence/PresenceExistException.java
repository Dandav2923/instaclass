package com.clan.instaclass.classService.exceptions.presence;

public class PresenceExistException extends Exception{
    public PresenceExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public PresenceExistException(String message){
        super(message);
    }
}
