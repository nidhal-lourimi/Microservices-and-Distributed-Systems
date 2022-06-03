package com.billcom.notification;

import com.billcom.clients.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {
    private  final NotificationRepository notificationRepository;
    public void notificationSend(NotificationRequest notificationRequest) {
       Notification notification=Notification.builder()
               .toCustomerId(notificationRequest.toCustomerId())
               .toCustomerEmail(notificationRequest.toCustomerEmail())
               .message(notificationRequest.message())
               .sentAt(LocalDateTime.now())
               .sender("billcom")
               .build();
        notificationRepository.save(notification);
    }
}
