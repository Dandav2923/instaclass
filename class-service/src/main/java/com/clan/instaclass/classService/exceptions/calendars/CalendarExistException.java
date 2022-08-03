package com.clan.instaclass.classService.exceptions.calendars;

public class CalendarExistException extends Exception{
    public CalendarExistException(String message, Throwable throwable){
        super(message, throwable);
    }
    public CalendarExistException(String message){
        super(message);
    }
}
