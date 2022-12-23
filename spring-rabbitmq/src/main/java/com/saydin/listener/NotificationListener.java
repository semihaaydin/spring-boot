package com.saydin.listener;

import com.saydin.entity.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class NotificationListener {

    @RabbitListener(queues ="queue1")
    @Async
    public void handleMessage(Notification notification){
        System.out.println("Message..GET . Queue 1 "+notification.getNotificationId());
    }
}
