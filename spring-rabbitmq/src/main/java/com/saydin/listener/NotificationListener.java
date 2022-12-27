package com.saydin.listener;

import com.saydin.entity.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues ="saydin-queue1")
    @Async
    public void handleMessage(Notification notification) throws InterruptedException {
        System.out.println("RabbitListener 1 "+notification.getNotificationId() + " by: "+Thread.currentThread().getName());
    }

    @RabbitListener(queues ="saydin-queue1")
    @Async
    public void handleMessage2(Notification notification) throws InterruptedException {
        System.out.println("RabbitListener 2 "+notification.getNotificationId() + " by: "+Thread.currentThread().getName());
    }
}
