package com.example.chai1.androidapp.Database;

import java.util.List;

public interface LoadDataCallback<T> {
    void onDataLoaded(List<T> data);
}
