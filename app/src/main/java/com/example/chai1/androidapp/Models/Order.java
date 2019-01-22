package com.example.chai1.androidapp.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Date;


@Entity(tableName = "Order", foreignKeys = {@ForeignKey(entity = User.class,childColumns = "userId",parentColumns = "userId")})

public class Order {
    @PrimaryKey(autoGenerate = true)
    private int OrderId;
    private int userId;
   private String shipStreet;
   private String shipZip;
   private String shipCity;

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



    public String getShipStreet() {
        return shipStreet;
    }

    public void setShipStreet(String shipStreet) {
        this.shipStreet = shipStreet;
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }
}
