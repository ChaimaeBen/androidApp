package com.example.chai1.androidapp.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


import com.example.chai1.androidapp.Database.LoadDataCallback;
import com.example.chai1.androidapp.Database.ReviewDao;
import com.example.chai1.androidapp.Models.Review;

import java.util.List;

public class ReviewRepository {
    private ReviewDao mReviewDao;
    private DemoRoomDatabase myDb;

    public ReviewRepository(Application application) {
        myDb = DemoRoomDatabase.getDatabase(application);
        mReviewDao = myDb.reviewDao();

    }

    public void insertreviews(Review... reviews) {
        new insertReviewsAsyncTask(mReviewDao).execute(reviews);
    }

    private static class insertReviewsAsyncTask extends AsyncTask<Review, Void, Void> {

        private ReviewDao reviewDao;

        insertReviewsAsyncTask(ReviewDao dao) {
            this.reviewDao = dao;
        }

        @Override
        protected Void doInBackground(Review... reviews) {
            reviewDao.insert(reviews);
            return null;
        }
    }

    public void getAllreviews(@NonNull LoadDataCallback<Review> activityCallback) {
        new GetReviewsAsyncTask(mReviewDao, activityCallback).execute();
    }


    private static class GetReviewsAsyncTask extends AsyncTask<Void, Void, List<Review>> {

        private ReviewDao mReviewDao;
        private LoadDataCallback<Review> mCallback;

        GetReviewsAsyncTask(ReviewDao reviewDao, LoadDataCallback<Review> callback) {
            mReviewDao = reviewDao;
            mCallback = callback;

        }

        @Override
        protected List<Review> doInBackground(Void... voids) {
            return mReviewDao.getAll();
        }

        @Override
        protected void onPostExecute(List<Review> reviews) {
            super.onPostExecute(reviews);
            mCallback.onDataLoaded(reviews);
        }

    }
}
