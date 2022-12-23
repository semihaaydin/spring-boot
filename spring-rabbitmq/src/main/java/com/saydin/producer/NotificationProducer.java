package com.saydin.producer;

import com.saydin.entity.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    public void sendToQueue(Notification notification){
        System.out.println("Message..SET "+notification.getMessage());
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
    }
}
