package com.saydin.event;

import com.saydin.EventApplication;
import org.springframework.context.ApplicationEvent;

public class ReservationCreationEvent extends ApplicationEvent {

    public ReservationCreationEvent(Object source) {
        super(source);
    }
}
