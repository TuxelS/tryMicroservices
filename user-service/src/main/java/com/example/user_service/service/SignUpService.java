package com.example.user_service.service;

import com.example.user_service.client.NotificationServiceClient;
import com.example.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.example.common_lib.dto.UserDTO;
import org.example.common_lib.entity.NotificationEntity;
import org.example.common_lib.entity.UserEntity;
import org.example.common_lib.exception.DuplicateUserException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;
    private final NotificationServiceClient notificationServiceClient;

    @Transactional(rollbackFor = Exception.class)
    public UserEntity saveNewUser(UserEntity userEntity) {
        if(userRepository.existsByEmail(userEntity.getEmail())){
            throw new DuplicateUserException("Этот email уже занят.");
        }
        else
        {
            UserEntity savedUser = userRepository.save(userEntity);
            UserDTO userDTO = new UserDTO(userEntity.getUuid(),
                    userEntity.getFirstName(),
                    userEntity.getSecondName(),
                    userEntity.getEmail());
            NotificationEntity notificationEntity = notificationServiceClient.signUpNotification(userDTO).getBody();
            savedUser.addNotification(notificationEntity);
            return savedUser;
        }
    }
}
