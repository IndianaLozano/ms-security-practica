package com.redbee.mssecuritypractica.application.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg){
        super(msg);
    }
}