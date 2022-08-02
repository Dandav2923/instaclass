package com.clan.istituto.exception.docente;

public class NumeroNonValidoException extends Exception{

    public NumeroNonValidoException(String message, Throwable throwable) {
        super(message,throwable);
    }

    public NumeroNonValidoException(String message){
        super(message);
    }
}
