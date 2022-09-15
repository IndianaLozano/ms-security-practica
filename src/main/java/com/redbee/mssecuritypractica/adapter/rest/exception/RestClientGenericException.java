package com.redbee.mssecuritypractica.adapter.rest.exception;


import com.redbee.mssecuritypractica.config.ErrorCode;
import com.redbee.mssecuritypractica.config.GenericException;

public final class RestClientGenericException extends GenericException {

    public RestClientGenericException(ErrorCode errorCode) {
        super(errorCode);
    }

}
