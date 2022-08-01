package com.clan.istituto.exception.docente;

public class CFNonCorrettoException extends Exception{

    public CFNonCorrettoException(String message, Throwable throwable) {
        super(message,throwable);
    }

    public CFNonCorrettoException(String message){
        super(message);
    }
}
