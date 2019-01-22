package com.example.chai1.androidapp.Database.Repository;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.example.chai1.androidapp.Database.LoadDataCallback;
import com.example.chai1.androidapp.Database.Repository.DemoRoomDatabase;
import com.example.chai1.androidapp.Database.UserDao;
import com.example.chai1.androidapp.Models.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends AndroidViewModel {

   private userRepository rep;

    public UserViewModel(@NonNull Application application) {
        super(application);
        rep = new userRepository(application);

    }
    public void insert(User users){
    rep.insertUsers(users);
    }



}
