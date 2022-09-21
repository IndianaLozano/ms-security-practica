package com.redbee.mssecuritypractica.adapter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redbee.mssecuritypractica.adapter.controller.model.AuthorisationResponse;
import com.redbee.mssecuritypractica.adapter.controller.model.AuthorizationRequest;
import com.redbee.mssecuritypractica.application.exception.UnauthorizedExeption;
import com.redbee.mssecuritypractica.application.port.in.AuthorizeCommand;
import com.redbee.mssecuritypractica.config.ErrorCode;
import com.redbee.mssecuritypractica.config.TestConfig;
import com.redbee.mssecuritypractica.domain.Authorization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SecurityController.class)
@Import(TestConfig.class)
public class SecurityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private String url  = "/security/token";

    @MockBean
    private AuthorizeCommand command;


    @DisplayName("Ingreso usuario y password incorrecto")
    @Test
    void testUserAndPasswordIncorrect() throws Exception{

        when(command.execute("test@test.com","Prueba1234")).thenThrow(new UnauthorizedExeption(ErrorCode.UNAUTHORIZED));
        AuthorizationRequest body = AuthorizationRequest.builder().email("test@test.com").password("Prueba1234").build();

        this.mockMvc.perform(
                post(url)
                        .content(objectMapper.writeValueAsString(body))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());


    }

    @DisplayName("Ingreso satisfactorio")
    @Test
    void testUserAndPasswordOk() throws Exception{

        AuthorisationResponse response = AuthorisationResponse
                .builder()
                .accessToken("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqV2ZRanQtRHlZNE1PSi1EZ1lMaHluMXVMNm9qdDN3SzJLLWZuYzZkVHFzIn0.eyJleHAiOjE2NjM2OTI4MjYsImlhdCI6MTY2MzY5MjIyNiwianRpIjoiZDdkNWFkNDAtMDhmYy00Zjk4LWE3MjktZjI4YmJjOGMzNmQyIiwiaXNzIjoiaHR0cDovL2tleWNsb2FrLmJhY2tlbmQ6ODA4MC9hdXRoL3JlYWxtcy90cmVzZGUiLCJzdWIiOiIyZDQ0Y2MwOC01NzUzLTQzMjctYTI5MC1mZjBiNDdmM2ViYjMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTQU5UQU5ERVIiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiY2xpZW50SG9zdCI6IjEwLjE4Ni4xMDEuNTgiLCJjbGllbnRJZCI6IlNBTlRBTkRFUiIsInByZWZlcnJlZF91c2VybmFtZSI6InNlcnZpY2UtYWNjb3VudC1zYW50YW5kZXIiLCJjbGllbnRBZGRyZXNzIjoiMTAuMTg2LjEwMS41OCJ9.KKMekSrmETpAp8GYI7a1x4PQmAdjwnrmbKRnvnGC2A6FJ7y7u9Np4LwvFS58puwM7K3fDT0iLEnrrjIKAj7CcGPPpGlhvKGM_uH4RH1RP4jTW6_Tw5m0LplfuWQKO0Spoy5kfc6XrHM7SqO_8JfjhVUunbTDXF0c2Hv2n3PTyoVQ3mWiUesGXwdGhotKrVyJgEt2IuWYo84KX0Iqp-m_67JlSt74mS8033cdsGqxFQ-qZlhRYdi2murek1yqd_Z749EE9XsxCYZig82WSYjBztSWR6siAX33SsjKqMT4vtZUHFd1TBrRTxteFYO7rOwgfwCoRNWpWC2Cazjs9gHpGg")
                .expiresIn(600)
                .tokenType("Bearer").refreshExpiresIn(900).refreshToken("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqV2ZRanQtRHlZNE1PSi1EZ1lMaHluMXVMNm9qdDN3SzJLLWZuYzZkVHFzIn0.eyJleHAiOjE2NjM2OTI4MjYsImlhdCI6MTY2MzY5MjIyNiwianRpIjoiZDdkNWFkNDAtMDhmYy00Zjk4LWE3MjktZjI4YmJjOGMzNmQyIiwiaXNzIjoiaHR0cDovL2tleWNsb2FrLmJhY2tlbmQ6ODA4MC9hdXRoL3JlYWxtcy90cmVzZGUiLCJzdWIiOiIyZDQ0Y2MwOC01NzUzLTQzMjctYTI5MC1mZjBiNDdmM2ViYjMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTQU5UQU5ERVIiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiY2xpZW50SG9zdCI6IjEwLjE4Ni4xMDEuNTgiLCJjbGllbnRJZCI6IlNBTlRBTkRFUiIsInByZWZlcnJlZF91c2VybmFtZSI6InNlcnZpY2UtYWNjb3VudC1zYW50YW5kZXIiLCJjbGllbnRBZGRyZXNzIjoiMTAuMTg2LjEwMS41OCJ9.KKMekSrmETpAp8GYI7a1x4PQmAdjwnrmbKRnvnGC2A6FJ7y7u9Np4LwvFS58puwM7K3fDT0iLEnrrjIKAj7CcGPPpGlhvKGM_uH4RH1RP4jTW6_Tw5m0LplfuWQKO0Spoy5kfc6XrHM7SqO_8JfjhVUunbTDXF0c2Hv2n3PTyoVQ3mWiUesGXwdGhotKrVyJgEt2IuWYo84KX0Iqp-m_67JlSt74mS8033cdsGqxFQ-qZlhRYdi2murek1yqd_Z749EE9XsxCYZig82WSYjBztSWR6siAX33SsjKqMT4vtZUHFd1TBrRTxteFYO7rOwgfwCoRNWpWC2Cazjs9gHpGg")
                .build();

        when(command.execute("test@test.com","Prueba1234")).thenReturn(Authorization.builder().accessToken("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqV2ZRanQtRHlZNE1PSi1EZ1lMaHluMXVMNm9qdDN3SzJLLWZuYzZkVHFzIn0.eyJleHAiOjE2NjM2OTI4MjYsImlhdCI6MTY2MzY5MjIyNiwianRpIjoiZDdkNWFkNDAtMDhmYy00Zjk4LWE3MjktZjI4YmJjOGMzNmQyIiwiaXNzIjoiaHR0cDovL2tleWNsb2FrLmJhY2tlbmQ6ODA4MC9hdXRoL3JlYWxtcy90cmVzZGUiLCJzdWIiOiIyZDQ0Y2MwOC01NzUzLTQzMjctYTI5MC1mZjBiNDdmM2ViYjMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTQU5UQU5ERVIiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiY2xpZW50SG9zdCI6IjEwLjE4Ni4xMDEuNTgiLCJjbGllbnRJZCI6IlNBTlRBTkRFUiIsInByZWZlcnJlZF91c2VybmFtZSI6InNlcnZpY2UtYWNjb3VudC1zYW50YW5kZXIiLCJjbGllbnRBZGRyZXNzIjoiMTAuMTg2LjEwMS41OCJ9.KKMekSrmETpAp8GYI7a1x4PQmAdjwnrmbKRnvnGC2A6FJ7y7u9Np4LwvFS58puwM7K3fDT0iLEnrrjIKAj7CcGPPpGlhvKGM_uH4RH1RP4jTW6_Tw5m0LplfuWQKO0Spoy5kfc6XrHM7SqO_8JfjhVUunbTDXF0c2Hv2n3PTyoVQ3mWiUesGXwdGhotKrVyJgEt2IuWYo84KX0Iqp-m_67JlSt74mS8033cdsGqxFQ-qZlhRYdi2murek1yqd_Z749EE9XsxCYZig82WSYjBztSWR6siAX33SsjKqMT4vtZUHFd1TBrRTxteFYO7rOwgfwCoRNWpWC2Cazjs9gHpGg")
                .expiresIn(600)
                .tokenType("Bearer").refreshExpiresIn(900).refreshToken("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJqV2ZRanQtRHlZNE1PSi1EZ1lMaHluMXVMNm9qdDN3SzJLLWZuYzZkVHFzIn0.eyJleHAiOjE2NjM2OTI4MjYsImlhdCI6MTY2MzY5MjIyNiwianRpIjoiZDdkNWFkNDAtMDhmYy00Zjk4LWE3MjktZjI4YmJjOGMzNmQyIiwiaXNzIjoiaHR0cDovL2tleWNsb2FrLmJhY2tlbmQ6ODA4MC9hdXRoL3JlYWxtcy90cmVzZGUiLCJzdWIiOiIyZDQ0Y2MwOC01NzUzLTQzMjctYTI5MC1mZjBiNDdmM2ViYjMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTQU5UQU5ERVIiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiY2xpZW50SG9zdCI6IjEwLjE4Ni4xMDEuNTgiLCJjbGllbnRJZCI6IlNBTlRBTkRFUiIsInByZWZlcnJlZF91c2VybmFtZSI6InNlcnZpY2UtYWNjb3VudC1zYW50YW5kZXIiLCJjbGllbnRBZGRyZXNzIjoiMTAuMTg2LjEwMS41OCJ9.KKMekSrmETpAp8GYI7a1x4PQmAdjwnrmbKRnvnGC2A6FJ7y7u9Np4LwvFS58puwM7K3fDT0iLEnrrjIKAj7CcGPPpGlhvKGM_uH4RH1RP4jTW6_Tw5m0LplfuWQKO0Spoy5kfc6XrHM7SqO_8JfjhVUunbTDXF0c2Hv2n3PTyoVQ3mWiUesGXwdGhotKrVyJgEt2IuWYo84KX0Iqp-m_67JlSt74mS8033cdsGqxFQ-qZlhRYdi2murek1yqd_Z749EE9XsxCYZig82WSYjBztSWR6siAX33SsjKqMT4vtZUHFd1TBrRTxteFYO7rOwgfwCoRNWpWC2Cazjs9gHpGg")
                .build());
        AuthorizationRequest body = AuthorizationRequest.builder().email("test@test.com").password("Prueba1234").build();

        this.mockMvc.perform(
                post(url)
                        .content(objectMapper.writeValueAsString(body))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));


    }

}
