package com.example.chai1.androidapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.chai1.androidapp.Models.Author;
import com.example.chai1.androidapp.Models.Book;

import java.util.List;

@Dao
public interface AuthorDao {

    @Query("SELECT * FROM Author")
    List<Author> getAll();

    @Query("SELECT * FROM Author where name LIKE :name")
    Author getByName(String name);

    @Query("DELETE FROM Author")
    void deleteAll();

    @Insert
    void insert(Author... author);

    @Update
    void Update(Author author);

    @Query("DELETE FROM Author where author_id = :author_id")
    void deleteById(int author_id);
}
