package com.clan.instaclass.classService.exceptions.calendars;

public class CalendarNotValidException extends Exception{
    public CalendarNotValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public CalendarNotValidException(String message){
        super(message);
    }
}
