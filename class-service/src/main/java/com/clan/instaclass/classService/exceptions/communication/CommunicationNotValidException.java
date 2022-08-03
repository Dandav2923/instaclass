package com.clan.instaclass.classService.exceptions.communication;

public class CommunicationNotValidException extends Exception{
    public CommunicationNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public CommunicationNotValidException(String message){
        super(message);
    }
}
