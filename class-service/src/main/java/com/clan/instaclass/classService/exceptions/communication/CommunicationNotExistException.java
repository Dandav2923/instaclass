package com.clan.instaclass.classService.exceptions.communication;

public class CommunicationNotExistException extends Exception{
    public CommunicationNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public CommunicationNotExistException(String message){
        super(message);
    }
}
