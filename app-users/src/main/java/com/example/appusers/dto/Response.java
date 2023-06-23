package com.example.appusers.dto;

import com.example.appusers.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private Object body;
    private Status status;

}
