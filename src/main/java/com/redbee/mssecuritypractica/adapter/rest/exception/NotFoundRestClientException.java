package com.redbee.mssecuritypractica.adapter.rest.exception;


import com.redbee.mssecuritypractica.config.ErrorCode;
import com.redbee.mssecuritypractica.config.GenericException;

public final class NotFoundRestClientException extends GenericException {

    public NotFoundRestClientException(ErrorCode errorCode) {
        super(errorCode);
    }
}
