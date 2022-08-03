package com.clan.instaclass.classService.exceptions.studentNote;

public class StudentNoteExistException extends Exception{
    public StudentNoteExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public StudentNoteExistException(String message){
        super(message);
    }
}
