package com.clan.instaclass.instituteService.exceptions.institute;

public class InstituteNotFoundException extends Exception {

    public InstituteNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
    public InstituteNotFoundException(String message){
        super(message);
    }

    public InstituteNotFoundException() {

    }
}
