package com.clan.instaclass.classService.exceptions.calendars;

public class CalendarNotExistException extends Exception{
    public CalendarNotExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public CalendarNotExistException(String message){
        super(message);
    }
}
