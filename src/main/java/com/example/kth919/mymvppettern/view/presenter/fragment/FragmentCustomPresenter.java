package com.example.kth919.mymvppettern.view.presenter.fragment;

import android.app.Application;

import com.example.kth919.mymvppettern.view.repository.CustomRoom;
import com.example.kth919.mymvppettern.view.repository.CustomRoomRepo;

import java.util.List;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import static com.google.common.base.Preconditions.checkNotNull;

public class FragmentCustomPresenter implements FragmentContract.PresenterFragment {

    private FragmentContract.ViewFragment view;
    private CustomRoomRepo customRoomRepo;

    public FragmentCustomPresenter(Application application, FragmentContract.ViewFragment view) {
        this.customRoomRepo = new CustomRoomRepo(application);
        this.view = checkNotNull(view);
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    //프레젠터를 가진 뷰가 이 함수를 호출하면 뷰가
    @Override
    public void updateTxt(LifecycleOwner lifecycleOwner){
        loadData().observe(lifecycleOwner, new Observer<List<CustomRoom>>() {
            @Override
            public void onChanged(List<CustomRoom> customRooms) {
                view.showText(customRooms.get(0).getTitle());
            }
        });
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
