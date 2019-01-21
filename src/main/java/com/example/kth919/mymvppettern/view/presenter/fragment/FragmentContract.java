package com.example.kth919.mymvppettern.view.presenter.fragment;

import com.example.kth919.mymvppettern.view.repository.CustomRoom;

import java.util.List;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

public interface FragmentContract {

    //view의 행위에 대한 인터페이스
    interface ViewFragment extends FragmentBaseView<PresenterFragment> {

        void showText(String txt);
    }

    //프레젠터의 행위에 대한 인터페이스
    interface PresenterFragment extends FragmentBasePresenter {

        void saveData(CustomRoom customRoom);

        LiveData<List<CustomRoom>> loadData();

        int getCount();

        void updateTxt(LifecycleOwner lifecycleOwner);
    }

}
