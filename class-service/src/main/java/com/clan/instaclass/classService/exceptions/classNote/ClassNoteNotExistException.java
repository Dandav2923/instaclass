package com.clan.instaclass.classService.exceptions.classNote;

public class ClassNoteNotExistException extends Exception{
    public ClassNoteNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassNoteNotExistException(String message){
        super(message);
    }
}
