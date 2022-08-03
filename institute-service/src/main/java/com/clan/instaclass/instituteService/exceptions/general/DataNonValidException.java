package com.clan.instaclass.instituteService.exceptions.general;

public class DataNonValidException extends Exception {

    public DataNonValidException(String message, Throwable throwable){
        super(message, throwable);
    }
    public DataNonValidException(String message){
        super(message);
    }

    public DataNonValidException() {

    }
}
