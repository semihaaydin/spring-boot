package com.saydin.api;

import com.saydin.request.HotelRequest;
import com.saydin.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingApi {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public void bookHotel(@RequestBody HotelRequest hotelRequest){
        reservationService.publishReservationEvent(hotelRequest);
        System.out.println("Kullanici Isteği İşleme Alındı" + hotelRequest);
    }



}
