package com.redbee.mssecuritypractica.application.usecase;


import com.redbee.mssecuritypractica.application.port.in.AuthorizeCommand;
import com.redbee.mssecuritypractica.domain.Authorization;
import org.springframework.stereotype.Component;

@Component
public class AuthorizeUseCase implements AuthorizeCommand {
    @Override
    public Authorization execute(String email, String password) {
        return null;
    }
}
