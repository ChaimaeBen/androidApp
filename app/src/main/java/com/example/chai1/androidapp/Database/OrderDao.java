package com.example.chai1.androidapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.chai1.androidapp.Models.Order;

import java.util.List;

@Dao
public interface OrderDao {

    @Query("SELECT * FROM `Order`")
    List<Order> getAll();

    @Query("DELETE FROM `Order`")
    void deleteAll();

    @Query("SELECT * FROM `Order` where OrderId=:Id")
    Order getById(int Id);

    @Insert
    void insert(Order...order);

    @Update
    void Update(Order order);

    @Query("DELETE FROM `Order` where OrderId = :id")
    void deleteById(int id);
}
