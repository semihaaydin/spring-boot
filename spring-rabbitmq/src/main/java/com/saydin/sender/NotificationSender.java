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
            int i=0;
            while (true) {
                i++;
                Notification notification=new Notification();
                notification.setNotificationId(i);
                notification.setMessage("First Procuder First Queue! ");
                notification.setCreatedTime(new Date());
                notification.setSeen(Boolean.FALSE);
                try {
                    Thread.sleep(5000); // 5 dakikaya bir q ya veri yaz.
                    producer.sendToQueue(notification);
                    producer.sendToQueue(notification);
                    producer.sendToQueue(notification);
                    producer.sendToQueue(notification);
                    producer.sendToQueue(notification);
                    producer.sendToQueue(notification);
                    producer.sendToQueue(notification);
                    producer.sendToQueue(notification);
                    producer.sendToQueue(notification);
                    producer.sendToQueue(notification);
                    producer.sendToQueue(notification);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("Notification sender");
        thread.start();
    }
}
