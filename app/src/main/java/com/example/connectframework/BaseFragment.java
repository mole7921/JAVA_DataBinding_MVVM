package com.example.connectframework;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

abstract class BaseFragment extends Fragment {

    protected NavController nav() {
        return NavHostFragment.findNavController(this);
    }
}
