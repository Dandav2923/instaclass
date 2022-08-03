package com.clan.instaclass.classService.exceptions.studentNote;

public class StudentNoteNotExistException extends Exception{
    public StudentNoteNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public StudentNoteNotExistException(String message){
        super(message);
    }
}
