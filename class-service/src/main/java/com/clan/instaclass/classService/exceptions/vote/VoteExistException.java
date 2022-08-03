package com.clan.instaclass.classService.exceptions.vote;

public class VoteExistException extends Exception{
    public VoteExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public VoteExistException(String message){
        super(message);
    }
}
