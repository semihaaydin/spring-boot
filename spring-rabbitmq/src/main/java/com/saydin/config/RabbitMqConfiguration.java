package com.saydin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration // Spring ayağa kalkarken bunu okusun
@EnableAsync
public class RabbitMqConfiguration {
    /*bir kıyruk oluşuturueken 3 temel tanımlama  var.
    1.excange 2.kuyruk 3. routing  */

    @Value("${sr.rabbit.queue.name}") //konfigüratif yaptı -> application properties
    private String queueName; //kuyruğun adı

    @Value("${sr.rabbit.routing.name}")
    private String routingName; //bining name

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName; //exchange name

    @Autowired
    private RabbitTemplate rabbitTemplate; //rabbit kuyruğuna gelmek için kullanırız.

    @Bean
    public Queue queue() { //amq dan gelir.
        return new Queue(queueName, true);
    }

    @Bean
    public DirectExchange directExchange() { ////amq dan gelir.
        return new DirectExchange(exchangeName);
    }

    @Bean ////amq dan gelir.
    public Binding binding(Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }
}
