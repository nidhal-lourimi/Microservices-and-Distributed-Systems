package com.billcom.notification;

import com.billcom.clients.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("api/v1/notification")
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping
    public void notificationSend(@RequestBody NotificationRequest notificationRequest){
        log.info("notification {} is received",notificationRequest);
        notificationService.notificationSend(notificationRequest);
    }
}
