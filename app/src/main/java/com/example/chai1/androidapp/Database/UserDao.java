package com.example.chai1.androidapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.example.chai1.androidapp.Models.User;

import java.util.List;


@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
   public List<User> getAll();

    @Query("SELECT * FROM User where firstname LIKE :username")
    User getByFirstName(String username);

    @Query("DELETE FROM User")
    void deleteAll();

    @Query("select*from User where Email=:em")
    User verifyEmail(String em);

    @Query("SELECT * FROM User where Email=:em and Password=:p" )
    User verifyUser(String em,String p);

    @Insert
    void insert(User user);

    @Update
    void Update(User user);

    @Query("SELECT * FROM User where UserId=:Id")
    int getById(int Id);

    @Query("DELETE FROM User where userId = :userId")
    void deleteById(int userId);


}
