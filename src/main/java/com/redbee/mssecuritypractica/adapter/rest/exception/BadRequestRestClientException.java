package com.redbee.mssecuritypractica.adapter.rest.exception;


import com.redbee.mssecuritypractica.config.ErrorCode;
import com.redbee.mssecuritypractica.config.GenericException;

public final class BadRequestRestClientException extends GenericException {

    public BadRequestRestClientException(ErrorCode errorCode) {
        super(errorCode);
    }
}
