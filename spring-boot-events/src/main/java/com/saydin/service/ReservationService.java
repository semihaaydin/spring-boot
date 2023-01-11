package com.saydin.service;

import com.saydin.event.ReservationCreationEvent;
import com.saydin.request.HotelRequest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ReservationService {

    @Autowired
    private  ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publishReservationEvent(HotelRequest hotelRequest){
        applicationEventPublisher.publishEvent(new ReservationCreationEvent(hotelRequest));
    }
}
