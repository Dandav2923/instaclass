package com.clan.instaclass.classService.exceptions.classTeacher;

public class ClassTeacherExistException extends Exception{
    public ClassTeacherExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public ClassTeacherExistException(String message){
        super(message);
    }
}
