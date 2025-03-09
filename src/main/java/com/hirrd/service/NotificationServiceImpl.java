package com.hirrd.service;

import com.hirrd.dto.NotificationDTO;
import com.hirrd.dto.NotificationStatus;
import com.hirrd.exception.JobPortalException;
import com.hirrd.model.Notification;
import com.hirrd.repository.NotificationRepository;
import com.hirrd.utility.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("notificationService")
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void sendNotification(NotificationDTO notificationDTO) throws JobPortalException {
        notificationDTO.setId(Utilities.getNextSequence("notification"));
        notificationDTO.setStatus(NotificationStatus.UNREAD);
        notificationDTO.setTimeStamp(LocalDateTime.now());
        notificationRepository.save(notificationDTO.toEntity());
    }

    @Override
    public List<Notification> getUnReadNotifications(Long userId) {
        return notificationRepository.findByUserIdAndStatus(userId, NotificationStatus.UNREAD);
    }
}
