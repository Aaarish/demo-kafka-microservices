package com.example.appusers.dto.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticateRequest {

    private String email;
    private String password;

}
