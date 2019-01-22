package com.example.chai1.androidapp.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.chai1.androidapp.Database.BookDao;
import com.example.chai1.androidapp.Database.LoadDataCallback;

import com.example.chai1.androidapp.Models.Book;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class bookRepository {

        private BookDao mBookDao;
        private DemoRoomDatabase myDb;

        public bookRepository(Application application) {
            myDb = DemoRoomDatabase.getDatabase(application);
            mBookDao = myDb.bookDao();

        }

    public void insertBooks (Book...books) {
        new insertBookAsyncTask(mBookDao).execute(books);
    }




    private static class insertBookAsyncTask extends AsyncTask<Book, Void, Void> {

        private BookDao bookDao;

        insertBookAsyncTask(BookDao dao) {
            this.bookDao = dao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDao.insert(books);
            return null;
        }
    }

    public List<Book> getAllBook(){
       return (List<Book>) new GetBooksAsyncTask(mBookDao).execute();
    }

        private static class GetBooksAsyncTask extends AsyncTask<Void, Void, List<Book>> {
            List<Book>list;
            private BookDao dao;

            public GetBooksAsyncTask(BookDao mBookDao) {
                dao=mBookDao;
            }

            @Override
            protected List<Book> doInBackground(Void... voids) {

                return dao.getAll();
            }


    }



}
