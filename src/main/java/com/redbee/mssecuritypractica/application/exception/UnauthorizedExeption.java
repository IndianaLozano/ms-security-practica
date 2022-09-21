package com.redbee.mssecuritypractica.application.exception;

import com.redbee.mssecuritypractica.config.ErrorCode;
import com.redbee.mssecuritypractica.config.GenericException;

public class UnauthorizedExeption extends GenericException {
    public UnauthorizedExeption(ErrorCode errorCode) {
        super(errorCode);
    }
}
