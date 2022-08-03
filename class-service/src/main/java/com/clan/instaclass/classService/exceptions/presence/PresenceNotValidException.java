package com.clan.instaclass.classService.exceptions.presence;

public class PresenceNotValidException extends Exception{
    public PresenceNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public PresenceNotValidException(String message){
        super(message);
    }
}
