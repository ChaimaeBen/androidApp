package com.example.chai1.androidapp.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.chai1.androidapp.Database.UserDao;

public class UserViewModel extends AndroidViewModel {
   private UserDao dao;

    public UserViewModel(@NonNull Application application) {
        super(application);
        dao =
    }
}
