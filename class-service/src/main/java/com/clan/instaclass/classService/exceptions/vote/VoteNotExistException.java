package com.clan.instaclass.classService.exceptions.vote;

public class VoteNotExistException extends Exception{
    public VoteNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public VoteNotExistException(String message){
        super(message);
    }
}
