package com.saydin.event.listener;

import com.saydin.event.ReservationCreationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationCreationListener {

    @EventListener
    public void reservationEventHandler(ReservationCreationEvent reservationCreationEvent) throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("EventListener -> " + reservationCreationEvent);
    }
}
