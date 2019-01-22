package com.example.chai1.androidapp.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.chai1.androidapp.Database.LoadDataCallback;
import com.example.chai1.androidapp.Database.CategoryDao;

import com.example.chai1.androidapp.Models.Category;

import java.util.List;

public class CategoryRepository {

    private CategoryDao mCategoryDao;

    private DemoRoomDatabase myDb;

    public CategoryRepository(Application application) {
        myDb = DemoRoomDatabase.getDatabase(application);
        mCategoryDao = myDb.categoryDao();
    }

    public void insertCategories(final Category category) {

            // alternatively to an AsyncTask, you can implement a runnable to run code on a separate thread
            Runnable runInsert = new Runnable() {
                @Override
                public void run() {
                    mCategoryDao.insert(category);
                }
            };

            // run the Runnable in a separate thread
            new Thread(runInsert).start();
        }




    public void getAllCategories(@NonNull LoadDataCallback<Category> activityCallback) {
        new GetCategoriesAsyncTask(mCategoryDao, activityCallback).execute();
    }

    private static class GetCategoriesAsyncTask extends AsyncTask<Void, Void, List<Category>> {
        private CategoryDao mCategoryDao;
        private LoadDataCallback<Category> mCallback;

        GetCategoriesAsyncTask(CategoryDao dao, LoadDataCallback<Category> mCallback) {
            this.mCategoryDao = dao;
            this.mCallback = mCallback;
        }

        @Override
        protected List<Category> doInBackground(Void... voids) {
            return mCategoryDao.getAll();
        }

        @Override
        protected void onPostExecute(List<Category> categories) {
            super.onPostExecute(categories);
            mCallback.onDataLoaded(categories);
        }
    }
}
