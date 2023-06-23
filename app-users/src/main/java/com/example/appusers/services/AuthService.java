package com.example.appusers.services;

import com.example.appusers.dto.requests.AuthenticateRequest;
import com.example.appusers.dto.requests.RegisterRequest;
import com.example.appusers.dto.responses.AuthenticateResponse;
import com.example.appusers.dto.responses.RegisterResponse;

public interface AuthService {

    RegisterResponse registerAppUser(RegisterRequest registerRequest);

    AuthenticateResponse authenticateAppUser(AuthenticateRequest loginRequest);
}
