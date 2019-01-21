package com.example.kth919.mymvppettern.view.repository;

import android.app.Application;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;

public class CustomRoomRepo {

    private CustomDao customDao;

    private LiveData<List<CustomRoom>> listLiveData;
    private ExecutorService executorService;

    public CustomRoomRepo(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);

        customDao = db.customDao();
        listLiveData = customDao.getAll();

        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<CustomRoom>> getAll() {
        return listLiveData;
    }

    public void insert(CustomRoom customRoom) {
        executorService.execute(() -> customDao.insert(customRoom));
    }

    public void delete(CustomRoom customRoom) {
        executorService.execute(() -> customDao.delete(customRoom));
    }

//    public int getItemCount() {
//
//        return customDao.getCount();
//    }

    public int getItemCount() {
        return customDao.getCount();
    }
}
