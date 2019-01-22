package com.example.chai1.androidapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.chai1.androidapp.Models.Review;

import java.util.List;

@Dao
public interface ReviewDao {
    @Query("SELECT * FROM Review")
    List<Review> getAll();

    @Query("DELETE FROM Review")
    void deleteAll();

    @Query("SELECT * FROM Review where review_id=:id")
    Review getById(int id);

    @Insert
    void insert(Review...reviews);

    @Update
    void Update(Review reviews);

    @Query("DELETE FROM Review where review_id= :id")
    void deleteById(int id);
}
