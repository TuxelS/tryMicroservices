package org.example.common_lib.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="notifications")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Column(name="text", nullable = false)
    private String text;
    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    // Автоматически устанавливается
    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "user_uuid", referencedColumnName = "uuid")
    @JsonIgnore
    private UserEntity user;

}
