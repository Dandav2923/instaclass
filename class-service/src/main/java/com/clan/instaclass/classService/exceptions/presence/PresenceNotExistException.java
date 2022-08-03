package com.clan.instaclass.classService.exceptions.presence;

public class PresenceNotExistException extends Exception{
    public PresenceNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public PresenceNotExistException(String message){
        super(message);
    }
}
