package com.example.chai1.androidapp.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.chai1.androidapp.Database.UserDao;
import com.example.chai1.androidapp.Models.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class userRepository {

    private UserDao mUserDao;

    private DemoRoomDatabase myDb;

    public userRepository(Application application) {
        myDb = DemoRoomDatabase.getDatabase(application);
        mUserDao = myDb.userDao();

    }


    public void insertUsers(final User users) {
       // new insertUsersAsyncTask(mUserDao).execute(users);

        // alternatively to an AsyncTask, you can implement a runnable to run code on a separate thread
        Runnable runInsert = new Runnable() {
            @Override
            public void run() {
                mUserDao.insert(users);
            }
        };

        // run the Runnable in a separate thread
        new Thread(runInsert).start();
    }

    public User verify(final String email,final String pa) {

    return mUserDao.verifyUser(email,pa);

    }

    private static class insertUsersAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao userDao;

        insertUsersAsyncTask(UserDao dao) {
            this.userDao = dao;
        }


        @Override
        protected Void doInBackground(final User... users) {
            userDao.insert(users[0]);
            return null;
        }

    }

    public List<User> getAllUser() throws ExecutionException, InterruptedException {
       return new GetUsersAsyncTask().execute().get();
    }


    private  class GetUsersAsyncTask extends AsyncTask<Void, Void, List<User>>
    {

        @Override
        protected List<User> doInBackground(Void... voids) {
            return myDb.userDao().getAll();
        }

    }

}


