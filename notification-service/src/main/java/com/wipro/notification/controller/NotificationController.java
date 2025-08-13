package com.wipro.notification.controller;





import com.wipro.notification.entity.Notification;
import com.wipro.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> sendNotification(@RequestBody Notification notification) throws MessagingException {
        return ResponseEntity.ok(notificationService.sendNotification(notification));
    }
}