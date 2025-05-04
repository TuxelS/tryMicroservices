package com.example.notification_service.repository;

import org.example.common_lib.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotificationRepository extends JpaRepository<NotificationEntity, UUID> {
    //пока не используется, мб в будущем что-то будет.
}
