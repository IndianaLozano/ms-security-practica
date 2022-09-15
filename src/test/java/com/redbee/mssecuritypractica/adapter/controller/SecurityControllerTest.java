package com.redbee.mssecuritypractica.adapter.controller;

import com.redbee.mssecuritypractica.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SecurityController.class)
@Import(TestConfig.class)
public class SecurityControllerTest {

    @Autowired
    private MockMvc mockMvc;

}
