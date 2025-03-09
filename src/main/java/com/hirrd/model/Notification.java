package com.hirrd.model;


import com.hirrd.dto.NotificationDTO;
import com.hirrd.dto.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection =  "notification")
public class Notification {

    private Long id;
    private Long userId;
    private String message;
    private String action;
    private String route;
    private LocalDateTime timeStamp;
    private NotificationStatus status;

    public NotificationDTO toDTO() {
        return new NotificationDTO(this.id, this.userId, this.message, this.action, this.route, this.timeStamp, this.status);
    }
}
