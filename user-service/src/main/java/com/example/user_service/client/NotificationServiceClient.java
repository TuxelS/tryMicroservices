package com.example.user_service.client;

import org.example.common_lib.dto.UserDTO;
import org.example.common_lib.entity.NotificationEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://notification-service:8082/api/notification-service")
public interface NotificationServiceClient {
    @PostMapping("/sign-up-notification")
    ResponseEntity<NotificationEntity> signUpNotification(@RequestBody UserDTO userDTO);
}
