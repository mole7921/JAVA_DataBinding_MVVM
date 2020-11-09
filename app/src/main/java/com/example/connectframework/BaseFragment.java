package com.example.connectframework;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

//定義NavController跳頁方法
abstract class BaseFragment extends Fragment {

    protected NavController nav() {
        return NavHostFragment.findNavController(this);
    }
}
