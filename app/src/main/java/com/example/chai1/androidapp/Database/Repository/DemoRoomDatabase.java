package com.example.chai1.androidapp.Database.Repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.chai1.androidapp.Database.AuthorDao;
import com.example.chai1.androidapp.Database.BookDao;
import com.example.chai1.androidapp.Database.CategoryDao;
import com.example.chai1.androidapp.Database.OrderDao;
import com.example.chai1.androidapp.Database.ReviewDao;
import com.example.chai1.androidapp.Database.UserDao;
import com.example.chai1.androidapp.Models.Author;
import com.example.chai1.androidapp.Models.Book;
import com.example.chai1.androidapp.Models.Category;
import com.example.chai1.androidapp.Models.Order;
import com.example.chai1.androidapp.Models.OrderDetail;
import com.example.chai1.androidapp.Models.Review;
import com.example.chai1.androidapp.Models.User;


    @Database(entities = {User.class,Book.class,Author.class,Category.class,Order.class,OrderDetail.class,Review.class},version = 4)
    public abstract class DemoRoomDatabase extends RoomDatabase {
        public abstract UserDao userDao();
        public abstract BookDao bookDao();
        public abstract AuthorDao authorDao();
        public abstract OrderDao orderDao();
        public abstract CategoryDao categoryDao();
        public abstract ReviewDao reviewDao();

        @SuppressWarnings("squid:S3008")
        private static volatile DemoRoomDatabase INSTANCE;

        static DemoRoomDatabase getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (DemoRoomDatabase.class) {
                    if (INSTANCE == null) {
                        // Create database
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                DemoRoomDatabase.class, "app_database").allowMainThreadQueries()
                                .fallbackToDestructiveMigration().build();
                    }
                }
            }
            return INSTANCE;
        }
    }

