package com.redbee.mssecuritypractica.adapter.controller;

import com.redbee.mssecuritypractica.adapter.controller.model.AuthorisationResponse;
import com.redbee.mssecuritypractica.adapter.controller.model.AuthorizationRequest;
import com.redbee.mssecuritypractica.application.port.in.AuthorizeCommand;
import com.redbee.mssecuritypractica.domain.Authorization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {


    private final AuthorizeCommand authorizeCommand;

    public SecurityController(AuthorizeCommand authorizeCommand){
        this.authorizeCommand = authorizeCommand;
    }


    @PostMapping("/security/token")
    public AuthorisationResponse authorize(@RequestBody AuthorizationRequest request){


        return AuthorisationResponse.fromDomain(authorizeCommand.execute(request.getEmail(),request.getPassword()));
    }
}
