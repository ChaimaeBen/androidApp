package com.example.chai1.androidapp.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.example.chai1.androidapp.Database.LoadDataCallback;
import com.example.chai1.androidapp.Database.OrderDao;
import com.example.chai1.androidapp.Models.Order;


import java.util.List;

public class orderRepository {
    private OrderDao mOrderDao;

    private DemoRoomDatabase myDb;

    public orderRepository(Application application) {
        myDb = DemoRoomDatabase.getDatabase(application);
        mOrderDao = myDb.orderDao();
    }

    public void insertOrders (Order...orders) {
        new insertOrdersAsyncTask(mOrderDao).execute(orders);
    }


    private static class insertOrdersAsyncTask extends AsyncTask<Order, Void, Void> {

        private OrderDao orderDao;

        insertOrdersAsyncTask(OrderDao dao) {
            this.orderDao = dao;
        }

        @Override
        protected Void doInBackground(Order... orders) {
            orderDao.insert(orders);
            return null;
        }
    }

    public void getAllOrders(@NonNull LoadDataCallback<Order> activityCallback) {
        new GetOrdersAsyncTask(mOrderDao, activityCallback).execute();
    }

    private static class GetOrdersAsyncTask extends AsyncTask<Void, Void, List<Order>> {
        private OrderDao mOrderDao;
        private LoadDataCallback<Order> mCallback;

        GetOrdersAsyncTask(OrderDao dao, LoadDataCallback<Order> mCallback) {
            this.mOrderDao = dao;
            this.mCallback = mCallback;
        }

        @Override
        protected List<Order> doInBackground(Void... voids) {
            return mOrderDao.getAll();
        }

        @Override
        protected void onPostExecute(List<Order> orders) {
            super.onPostExecute(orders);
            mCallback.onDataLoaded(orders);
        }
    }

}
