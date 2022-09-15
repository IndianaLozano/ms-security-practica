package com.redbee.mssecuritypractica.application.exception;


import com.redbee.mssecuritypractica.config.ErrorCode;
import com.redbee.mssecuritypractica.config.GenericException;

public class BusinessException extends GenericException {

    public BusinessException(ErrorCode errorCode){
        super(errorCode);
    }
}
