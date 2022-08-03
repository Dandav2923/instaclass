package com.clan.instaclass.classService.exceptions.communication;

public class CommunicationExistException extends Exception{
    public CommunicationExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public CommunicationExistException(String message){
        super(message);
    }
}
