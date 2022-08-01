package com.clan.istituto.exception.teacher;

public class DatiNonValidiException extends Exception{

    public DatiNonValidiException(String message, Throwable throwable) {
        super(message,throwable);
    }

    public DatiNonValidiException(String message){
        super(message);
    }
}
