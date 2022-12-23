package com.saydin.sender;

import com.saydin.entity.Notification;
import com.saydin.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Component
public class NotificationSender {

    @Autowired
    private NotificationProducer producer;

    @PostConstruct
    public void init() {
        getThread();

    }

    public void getThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                Notification notification=new Notification();
                notification.setNotificationId(UUID.randomUUID().toString());
                notification.setMessage("First Procuder First Queue! ");
                notification.setCreatedTime(new Date());
                notification.setSeen(Boolean.FALSE);
                producer.sendToQueue(notification);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("Notification sender");
        thread.start();
    }
}
