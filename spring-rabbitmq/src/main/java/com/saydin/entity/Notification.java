package com.saydin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Notification implements Serializable {
    //bu nesneyi kuruğa gönderebilmemiz için serilazible olması gerekmektedir.

    private int notificationId;
    private Date createdTime;
    private Boolean seen; //ulaşıldı mı
    private String message;

}
