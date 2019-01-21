package com.example.kth919.mymvppettern.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.os.Bundle;

import com.example.kth919.mymvppettern.R;
import com.example.kth919.mymvppettern.databinding.ActivityMainBinding;
import com.example.kth919.mymvppettern.view.presenter.activity.ActivityContract;
import com.example.kth919.mymvppettern.view.presenter.activity.CustomPresenter;
import com.example.kth919.mymvppettern.view.repository.CustomRoom;

import java.util.List;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;


public class MainActivity extends AppCompatActivity implements ActivityContract.View {

    private ActivityMainBinding activityMainBinding;
    private CustomPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPresenter = new CustomPresenter(this, getApplication());

        mPresenter.saveData(new CustomRoom(UUID.randomUUID().toString(), "testTitle"));

    }

    @Override
    public void showText() {

        mPresenter.loadData().observe(this, new Observer<List<CustomRoom>>() {
            @Override
            public void onChanged(List<CustomRoom> customRooms) {
                activityMainBinding.txt.setText(customRooms.get(0).getTitle());
            }
        });
    }

}
