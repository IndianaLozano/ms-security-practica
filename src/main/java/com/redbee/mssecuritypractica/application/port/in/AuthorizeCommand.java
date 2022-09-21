package com.redbee.mssecuritypractica.application.port.in;

import com.redbee.mssecuritypractica.domain.Authorization;

public interface AuthorizeCommand {

    Authorization execute(String email, String password);
}
