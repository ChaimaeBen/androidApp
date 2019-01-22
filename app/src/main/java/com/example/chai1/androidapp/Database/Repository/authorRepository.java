package com.example.chai1.androidapp.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.chai1.androidapp.Database.AuthorDao;

import com.example.chai1.androidapp.Database.LoadDataCallback;
import com.example.chai1.androidapp.Models.Author;


import java.util.List;

public class authorRepository {
    private AuthorDao mAuthorDao;

    private DemoRoomDatabase myDb;

    public authorRepository(Application application) {
        myDb = DemoRoomDatabase.getDatabase(application);
        mAuthorDao = myDb.authorDao();
    }

    public void insertAuthors (Author...authors) {
        new insertAuthorsAsyncTask(mAuthorDao).execute(authors);
    }

    private static class insertAuthorsAsyncTask extends AsyncTask<Author, Void, Void> {

        private AuthorDao authorDao;

        insertAuthorsAsyncTask(AuthorDao dao) {
            this.authorDao = dao;
        }

        @Override
        protected Void doInBackground(Author... authors) {
            authorDao.insert(authors);
            return null;
        }
    }


    public void getAllAuthors(@NonNull LoadDataCallback<Author> activityCallback) {
        new GetAuthorsAsyncTask(mAuthorDao, activityCallback).execute();
    }

    private static class GetAuthorsAsyncTask extends AsyncTask<Void, Void, List<Author>> {
        private AuthorDao mAuthorDao;
        private LoadDataCallback<Author> mCallback;

        GetAuthorsAsyncTask(AuthorDao dao, LoadDataCallback<Author> mCallback) {
            this.mAuthorDao = dao;
            this.mCallback = mCallback;
        }

        @Override
        protected List<Author> doInBackground(Void... voids) {
            return mAuthorDao.getAll();
        }

        @Override
        protected void onPostExecute(List<Author> authors) {
            super.onPostExecute(authors);
            mCallback.onDataLoaded(authors);
        }
    }
}
