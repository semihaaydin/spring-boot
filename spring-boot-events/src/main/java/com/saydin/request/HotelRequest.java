package com.saydin.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HotelRequest {
    private String userId;
    private String hotelId;
}
