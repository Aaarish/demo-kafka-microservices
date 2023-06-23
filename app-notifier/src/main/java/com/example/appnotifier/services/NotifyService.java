package com.example.appnotifier.services;

import com.example.appnotifier.event.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotifyService {

    @KafkaListener(topics = "notificationTopic")
    public void notifyApp(UserRegisterEvent event) {
        System.out.println("sending a notification to app-user for user-register event with id : " + event.getUserId());
    }

}
