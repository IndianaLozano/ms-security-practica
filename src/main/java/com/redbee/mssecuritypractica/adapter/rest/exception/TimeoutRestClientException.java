package com.redbee.mssecuritypractica.adapter.rest.exception;


import com.redbee.mssecuritypractica.config.ErrorCode;
import com.redbee.mssecuritypractica.config.GenericException;

public final class TimeoutRestClientException extends GenericException {

    public TimeoutRestClientException(ErrorCode errorCode) {
        super(errorCode);
    }

}
