package com.hirrd.service;

import com.hirrd.dto.NotificationDTO;
import com.hirrd.exception.JobPortalException;
import com.hirrd.model.Notification;

import java.util.List;

public interface NotificationService {

    public void sendNotification (NotificationDTO notificationDTO) throws JobPortalException;

    public List<Notification> getUnReadNotifications (Long userId);

    public void readNotifications(Long id) throws JobPortalException;
}
