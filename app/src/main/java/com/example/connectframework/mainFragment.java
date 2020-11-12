package com.example.connectframework;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.connectframework.databinding.FragmentMainBinding;
import com.example.viewmodel.MainViewModel;
import com.example.viewmodel.NavgateTo;


//首頁
public class mainFragment extends BaseFragment implements NavgateTo {

    private FragmentMainBinding fragmentMainBinding;
    private MainViewModel mainViewModel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startDataBinding();
    }

    private void startDataBinding() {
        fragmentMainBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_main);
        mainViewModel = new MainViewModel();
        mainViewModel.setNavgateTo(this);
        fragmentMainBinding.setMainViewModel(mainViewModel);
    }

    @Override
    public void naviTo(Bundle bundle) {
        nav().navigate(R.id.action_mainFragment_to_photoFragment);
    }
}