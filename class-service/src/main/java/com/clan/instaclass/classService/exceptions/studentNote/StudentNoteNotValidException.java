package com.clan.instaclass.classService.exceptions.studentNote;

public class StudentNoteNotValidException extends Exception{
    public StudentNoteNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public StudentNoteNotValidException(String message){
        super(message);
    }
}
