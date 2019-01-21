package com.example.kth919.mymvppettern.view.presenter.activity;

import android.app.Application;

import com.example.kth919.mymvppettern.view.repository.CustomRoom;
import com.example.kth919.mymvppettern.view.repository.CustomRoomRepo;

import java.util.List;

import androidx.lifecycle.LiveData;

public class CustomPresenter implements ActivityContract.Presenter{

    private CustomRoomRepo customRoomRepo;
    private ActivityContract.View view;

    public CustomPresenter(ActivityContract.View view, Application application) {
        this.customRoomRepo = new CustomRoomRepo(application);
        view = view;
    }

    public void updateTxt(){
        view.showText();
    }

    @Override
    public void saveData(CustomRoom customRoom) {
        customRoomRepo.insert(customRoom);
    }

    @Override
    public LiveData<List<CustomRoom>>  loadData() {
        return customRoomRepo.getAll();
    }

    @Override
    public int getCount() {
        return customRoomRepo.getItemCount();
    }
}
