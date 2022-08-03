package com.clan.instaclass.classService.exceptions.vote;

public class VoteNotValidException extends Exception{
    public VoteNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public VoteNotValidException(String message){
        super(message);
    }
}
