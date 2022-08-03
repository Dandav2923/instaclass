package com.clan.instaclass.classService.exceptions.classTeacher;

public class ClassTeacherNotValidException extends Exception{
    public ClassTeacherNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassTeacherNotValidException(String message){
        super(message);
    }
}
