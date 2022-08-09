package com.clan.instaclass.classService.exceptions.classNote;

public class ClassNoteExistException extends Exception{
    public ClassNoteExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassNoteExistException(String message){
        super(message);
    }
}
