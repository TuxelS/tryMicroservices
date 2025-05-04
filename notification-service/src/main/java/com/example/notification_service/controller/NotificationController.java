package com.example.notification_service.controller;

import com.example.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.example.common_lib.dto.UserDTO;
import org.example.common_lib.entity.NotificationEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification-service")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    //Получение первого сообщения на почту об успешной регистрации
    @PostMapping("/sign-up-notification")
    public ResponseEntity<NotificationEntity> signUpNotification(@RequestBody UserDTO userDTO){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(notificationService.sendSignUpNotification(userDTO));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }
}
