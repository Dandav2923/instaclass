package com.clan.instaclass.classService.exceptions.classTeacher;

public class ClassTeacherNotExistException extends Exception{
    public ClassTeacherNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassTeacherNotExistException(String message){
        super(message);
    }
}
