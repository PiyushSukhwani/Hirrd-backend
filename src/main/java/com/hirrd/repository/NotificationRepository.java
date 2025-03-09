package com.hirrd.repository;

import com.hirrd.dto.NotificationStatus;
import com.hirrd.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository  extends MongoRepository<Notification, Long> {

    public List<Notification> findByUserIdAndStatus(Long userId, NotificationStatus status);
}
