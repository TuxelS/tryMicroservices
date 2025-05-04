package org.example.common_lib.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="second_name", nullable = false)
    private String secondName;
    @Column(name="email", nullable = false, unique = true)
    private String email;
    @Column(name="password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<NotificationEntity> notifications = new ArrayList<>();

    public void addNotification(NotificationEntity notificationEntity){
        notifications.add(notificationEntity);
        notificationEntity.setUser(this);
    }
}
