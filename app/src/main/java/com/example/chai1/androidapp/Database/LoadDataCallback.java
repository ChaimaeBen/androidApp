package org.example.we04room.database;

import java.util.List;

public interface LoadDataCallback<T> {
    void onDataLoaded(List<T> data);
}
