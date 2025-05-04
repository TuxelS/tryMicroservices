package com.example.notification_service.service;

import com.example.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.example.common_lib.dto.UserDTO;
import org.example.common_lib.entity.NotificationEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public NotificationEntity sendSignUpNotification(UserDTO userDTO) {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setText(getSignUpMessage(userDTO).getText());
        javaMailSender.send(getSignUpMessage(userDTO));
        return notificationEntity;
    }

    public SimpleMailMessage getSignUpMessage(UserDTO userDTO){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(userDTO.getEmail());
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setSubject("Регистрация в сервисе");
        simpleMailMessage.setText("Здравствуйте, %s %s, спасибо за регистрацию в нашем приложении!"
                .formatted(userDTO.getFirstName(), userDTO.getSecondName()));
        return simpleMailMessage;
    }
}
