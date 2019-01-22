package com.example.chai1.androidapp.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;



@Entity(tableName = "OrderDetail", foreignKeys = {@ForeignKey(entity = Order.class,childColumns = "OrderId",parentColumns = "OrderId"),
        @ForeignKey(entity = Book.class,childColumns = "ISBN",parentColumns = "ISBN")}
)

public class OrderDetail {
    @PrimaryKey(autoGenerate = true)
    private int OrderDetail_id;
    private int OrderId;
    private String ISBN;
    private int quantity;

    public int getOrderDetail_id() {
        return OrderDetail_id;
    }

    public void setOrderDetail_id(int orderDetail_id) {
        OrderDetail_id = orderDetail_id;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
