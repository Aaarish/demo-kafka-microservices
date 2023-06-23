package com.example.appusers.dto;

import com.example.appusers.entities.Name;
import com.example.appusers.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserDto {

    @JsonProperty(value = "user_id")
    private String id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private Gender gender;
    private int age;
    private String email;
    private String password;

}
