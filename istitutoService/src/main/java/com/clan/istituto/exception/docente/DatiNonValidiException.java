package com.clan.istituto.exception.docente;

public class DatiNonValidiException extends Exception{

    public DatiNonValidiException(String message, Throwable throwable) {
        super(message,throwable);
    }

    public DatiNonValidiException(String message){
        super(message);
    }
}
