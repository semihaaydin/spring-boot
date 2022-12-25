package com.saydin.listener;

import com.saydin.entity.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues ="saydin-queue1")
    public void handleMessage(Notification notification) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Message..GET . Queue 1 "+notification.getCreatedTime().toString());
    }
}
