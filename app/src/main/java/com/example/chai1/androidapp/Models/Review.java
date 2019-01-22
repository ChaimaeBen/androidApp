package com.example.chai1.androidapp.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "Review", foreignKeys = {@ForeignKey(entity = Book.class,childColumns = "ISBN",parentColumns = "ISBN"),
        @ForeignKey(entity = User.class,childColumns = "userId",parentColumns = "userId")})

public class Review {
    @PrimaryKey(autoGenerate = true)
    private int review_id;
    private String ISBN;
    private String comment;
    private int userId;
    private int rating;
    private String Email;


    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
