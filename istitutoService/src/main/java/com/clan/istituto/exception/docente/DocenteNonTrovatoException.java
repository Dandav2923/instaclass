package com.clan.istituto.exception.docente;

public class DocenteNonTrovatoException extends Exception{

    public DocenteNonTrovatoException(String message, Throwable throwable) {
        super(message,throwable);
    }

    public DocenteNonTrovatoException(String message){
        super(message);
    }
}
