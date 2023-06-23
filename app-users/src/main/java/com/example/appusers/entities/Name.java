package com.example.appusers.entities;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
        @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
})
public class Name {

    private String firstName;
    private String lastName;

}

