package com.example.chai1.androidapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.example.chai1.androidapp.Models.Category;

import java.util.List;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM Category")
    List<Category> getAll();

    @Query("DELETE FROM Category")
    void deleteAll();

    @Query("SELECT * FROM Category where category_id=:Id")
    Category getById(int Id);

    @Insert
    void insert(Category category);

    @Update
    void Update(Category category);

    @Query("DELETE FROM Category where category_id = :id")
    void deleteById(int id);
}
