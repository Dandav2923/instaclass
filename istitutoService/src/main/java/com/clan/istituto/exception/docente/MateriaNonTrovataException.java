package com.clan.istituto.exception.docente;

public class MateriaNonTrovataException extends Exception{

    public MateriaNonTrovataException(String message, Throwable throwable) {
        super(message,throwable);
    }

    public MateriaNonTrovataException(String message){
        super(message);
    }
}
