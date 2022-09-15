package com.redbee.mssecuritypractica.adapter.rest.exception;


import com.redbee.mssecuritypractica.config.ErrorCode;
import com.redbee.mssecuritypractica.config.GenericException;

public final class EmptyOrNullBodyRestClientException extends GenericException {

    public EmptyOrNullBodyRestClientException(ErrorCode errorCode) {
        super(errorCode);
    }

}
