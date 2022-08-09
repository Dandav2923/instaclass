package com.clan.instaclass.classService.exceptions.classNote;

public class ClassNoteNotValidException extends Exception{
    public ClassNoteNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassNoteNotValidException(String message){
        super(message);
    }
}
