package com.example.appusers.entities;

import com.example.appusers.enums.Gender;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "app_users")
public class AppUser {

    @Id
    @Column(name = "user_id")
    private String id;

    @Embedded
    private Name name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private int age;
    private String email;
    private String password;

}
