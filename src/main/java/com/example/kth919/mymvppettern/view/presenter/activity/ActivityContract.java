package com.example.kth919.mymvppettern.view.presenter.activity;

import com.example.kth919.mymvppettern.view.repository.CustomRoom;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface ActivityContract {
    //view의 행위에 대한 인터페이스
    interface View extends BaseView<Presenter> {

        void showText();
    }

    //프레젠터의 행위에 대한 인터페이스
    interface Presenter extends BasePresenter {

        void saveData(CustomRoom customRoom);

        LiveData<List<CustomRoom>> loadData();

        int getCount();

    }
}
