package com.example.chai1.androidapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.chai1.androidapp.Models.Book;

import java.util.List;

@Dao
public interface BookDao   {

    @Query("SELECT * FROM Book")
    List<Book> getAll();

    @Query("SELECT * FROM Book where title LIKE :title")
    Book getByTitle(String title);

    @Query("SELECT * FROM Book where ISBN=:Id")
    Book getById(int Id);

    @Query("DELETE FROM Book")
    void deleteAll();

    @Insert
    void insert(Book... book);

    @Update
    void Update(Book book);

    @Query("DELETE FROM Book where ISBN = :ISBN")
    void deleteById(int ISBN);


}
