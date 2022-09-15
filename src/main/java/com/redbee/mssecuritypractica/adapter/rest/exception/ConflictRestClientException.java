package com.redbee.mssecuritypractica.adapter.rest.exception;


import com.redbee.mssecuritypractica.config.ErrorCode;
import com.redbee.mssecuritypractica.config.GenericException;

public class ConflictRestClientException extends GenericException {
    public ConflictRestClientException(ErrorCode ec) {
        super(ec);
    }
}
