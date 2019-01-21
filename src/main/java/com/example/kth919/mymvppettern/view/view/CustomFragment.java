package com.example.kth919.mymvppettern.view.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kth919.mymvppettern.R;
import com.example.kth919.mymvppettern.databinding.FragmentCustomBinding;
import com.example.kth919.mymvppettern.view.presenter.fragment.FragmentContract;
import com.example.kth919.mymvppettern.view.repository.CustomRoom;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import static com.google.common.base.Preconditions.checkNotNull;

public class CustomFragment extends Fragment implements FragmentContract.ViewFragment {

    private FragmentContract.PresenterFragment presenter;
    private FragmentCustomBinding fragmentCustomBinding;

    public CustomFragment() {
        // Requires empty public constructor
    }

    public static CustomFragment newInstance() {
        return new CustomFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //원하는 시점에 이 함수를 호출하면 그에 맞는 행동을 취함.
        presenter.updateTxt(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentCustomBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_custom, container, false);

        return fragmentCustomBinding.getRoot();
    }

    @Override
    public void showText(String txt) {

        fragmentCustomBinding.txt.setText(txt);

//        presenter.loadData().observe(this, new Observer<List<CustomRoom>>() {
//            @Override
//            public void onChanged(List<CustomRoom> customRooms) {
//                fragmentCustomBinding.txt.setText(customRooms.get(0).getTitle());
//            }
//        });
    }

    @Override
    public void setPresenter(FragmentContract.PresenterFragment presenter) {
        this.presenter = checkNotNull(presenter);
    }

}
