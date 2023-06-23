package com.example.appusers.dto.requests;

import com.example.appusers.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String gender;
    private int age;
    private String email;
    private String password;

}
