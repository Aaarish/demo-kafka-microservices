package com.example.appusers.services.impl;

import com.example.appusers.dao.AppUserRepo;
import com.example.appusers.dto.requests.AuthenticateRequest;
import com.example.appusers.dto.requests.RegisterRequest;
import com.example.appusers.dto.responses.AuthenticateResponse;
import com.example.appusers.dto.responses.RegisterResponse;
import com.example.appusers.entities.AppUser;
import com.example.appusers.entities.Name;
import com.example.appusers.event.UserRegisterEvent;
import com.example.appusers.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.appusers.enums.Gender.FEMALE;
import static com.example.appusers.enums.Gender.MALE;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AppUserRepo appUserRepo;

    private final KafkaTemplate<String, UserRegisterEvent> kafkaTemplate;

    @Override
    public RegisterResponse registerAppUser(RegisterRequest registerRequest) {
        AppUser appUser = new AppUser();

        appUser.setId(UUID.randomUUID().toString());
        appUser.setName(new Name(registerRequest.getFirstName(), registerRequest.getLastName()));
        appUser.setAge(registerRequest.getAge());
        appUser.setGender(registerRequest.getGender().equalsIgnoreCase("M") ? MALE : FEMALE);
        appUser.setEmail(registerRequest.getEmail());
        appUser.setPassword(registerRequest.getPassword());

        AppUser savedAppUser = appUserRepo.save(appUser);

        try {
            UserRegisterEvent registerEvent = new UserRegisterEvent(savedAppUser.getId(), "User created successfully !");
            kafkaTemplate.send("notificationTopic", registerEvent);
        } catch (Exception e) {
            log.error("Failed to send user-register event to kafka topic due to : {}", e.getMessage());
        }

        return RegisterResponse.builder()
                .message(String.format("App user with id = %s is successfully created !!!", savedAppUser.getId()))
                .build();
    }

    @Override
    public AuthenticateResponse authenticateAppUser(AuthenticateRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        AppUser appUser = appUserRepo
                .findByEmailAndPassword(email, password)
                .orElseThrow(() -> new ResourceNotFoundException("No such user found !!!"));

        return AuthenticateResponse.builder()
                .message(String.format("User with id = %s is authenticated !!!", appUser.getId()))
                .build();
    }

}
