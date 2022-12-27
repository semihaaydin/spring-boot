package com.saydin.producer;

import com.saydin.entity.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class NotificationProducer {
    //data gönderen kısım burası

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${sr.rabbit.routing.name}")
    private String routingName; //bining name

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName; //exchange name


    @Async
    public void sendToQueue(Notification notification) throws InterruptedException {
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
        System.out.println("Sending queue1 "+notification.getNotificationId() + " by: "+Thread.currentThread().getName());
    }

}
