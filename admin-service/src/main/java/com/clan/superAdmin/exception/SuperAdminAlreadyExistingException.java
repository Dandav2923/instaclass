package com.clan.superAdmin.exception;

public class SuperAdminAlreadyExistingException extends Exception{
    public SuperAdminAlreadyExistingException(String message, Throwable throwable){
        super(message, throwable);
    }
    public SuperAdminAlreadyExistingException(String message){
        super(message);
    }
}
