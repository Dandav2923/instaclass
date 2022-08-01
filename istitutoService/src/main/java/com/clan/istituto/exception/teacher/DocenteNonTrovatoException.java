package com.clan.istituto.exception.teacher;

public class DocenteNonTrovatoException extends Exception{

    public DocenteNonTrovatoException(String message, Throwable throwable) {
        super(message,throwable);
    }

    public DocenteNonTrovatoException(String message){
        super(message);
    }
}
