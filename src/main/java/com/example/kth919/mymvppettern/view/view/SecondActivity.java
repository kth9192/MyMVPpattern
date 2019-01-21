package com.example.kth919.mymvppettern.view.view;

import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

import com.example.kth919.mymvppettern.R;
import com.example.kth919.mymvppettern.databinding.ActivitySecondBinding;
import com.example.kth919.mymvppettern.view.presenter.fragment.FragmentCustomPresenter;
import com.example.kth919.mymvppettern.view.repository.CustomRoom;
import com.example.kth919.mymvppettern.view.view.CustomFragment;

import java.util.UUID;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding activitySecondBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        CustomFragment fragment = new CustomFragment();
        fragmentTransaction.add(R.id.plate, fragment);
        fragmentTransaction.commit();

        //presenter 를 선언. 통신을 위해 상호작용할 view를 전달
        FragmentCustomPresenter presenter = new FragmentCustomPresenter(getApplication(), fragment);

        //사용할 데이터
        presenter.saveData(new CustomRoom(UUID.randomUUID().toString(), "testTitle"));
    }

}
