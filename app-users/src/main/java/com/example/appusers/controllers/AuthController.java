package com.example.appusers.controllers;

import com.example.appusers.dto.Response;
import com.example.appusers.dto.requests.AuthenticateRequest;
import com.example.appusers.dto.requests.RegisterRequest;
import com.example.appusers.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.appusers.enums.Status.FAIL;
import static com.example.appusers.enums.Status.SUCCESS;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Response> signUp(@RequestBody RegisterRequest registerRequest) {
        Response response = new Response();

        try {
            response.setBody(authService.registerAppUser(registerRequest));
            response.setStatus(SUCCESS);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        catch (Exception e) {
            response.setBody(e.getMessage());
            response.setStatus(FAIL);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody AuthenticateRequest authenticateRequest) {
        Response response = new Response();

        try {
            response.setBody(authService.authenticateAppUser(authenticateRequest));
            response.setStatus(SUCCESS);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        catch (Exception e) {
            response.setBody(e.getMessage());
            response.setStatus(FAIL);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
